"""Aggregates Allure's raw result files (one JSON per test) into the common
results.json format shared across all portfolio repositories."""

import json
import sys
import glob
from datetime import datetime, timezone

REPO_NAME = "restful-booker-restassured"
ALLURE_RESULTS_DIR = "target/allure-results"


def main():
    result_files = glob.glob(f"{ALLURE_RESULTS_DIR}/*-result.json")

    total = passed = failed = skipped = 0
    earliest_start = None
    latest_stop = None
    failures = []

    for file_path in result_files:
        with open(file_path, "r", encoding="utf-8") as f:
            data = json.load(f)

        status = data.get("status", "unknown")
        total += 1

        if status == "passed":
            passed += 1
        elif status in ("failed", "broken"):
            failed += 1
            details = data.get("statusDetails", {})
            failures.append({
                "name": data.get("name", "unknown"),
                "error_message": str(details.get("message", ""))[:300],
            })
        elif status == "skipped":
            skipped += 1

        start = data.get("start")
        stop = data.get("stop")
        if start is not None:
            earliest_start = start if earliest_start is None else min(earliest_start, start)
        if stop is not None:
            latest_stop = stop if latest_stop is None else max(latest_stop, stop)

    duration_seconds = 0
    if earliest_start is not None and latest_stop is not None:
        duration_seconds = round((latest_stop - earliest_start) / 1000, 2)

    result = {
        "repo": REPO_NAME,
        "total": total,
        "passed": passed,
        "failed": failed,
        "skipped": skipped,
        "duration_seconds": duration_seconds,
        "timestamp": datetime.now(timezone.utc).isoformat(),
        "failures": failures,
    }

    with open("results.json", "w", encoding="utf-8") as f:
        json.dump(result, f, indent=2)

    print(f"results.json generated for {REPO_NAME}: {passed}/{total} passed, {len(failures)} failure(s) recorded")


if __name__ == "__main__":
    sys.exit(main())