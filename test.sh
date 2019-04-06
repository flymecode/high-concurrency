#!/usr/bin/env bash
# -n 测试的数量 -c 并发数
ab -n 1000 -c 50 http://localhost:8080/test