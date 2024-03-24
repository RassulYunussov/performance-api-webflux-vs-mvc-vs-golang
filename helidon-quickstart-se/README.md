# Helidon SE

http://localhost:8084/performance-helidon?delay=100

## Testing with vegeta
On MacBook Pro M2
echo "GET http://localhost:8084/performance-helidon?delay=100" | vegeta attack -duration=60s -rate=500 | vegeta report

```
Requests      [total, rate, throughput]         30000, 500.02, 499.17
Duration      [total, attack, wait]             1m0s, 59.998s, 101.619ms
Latencies     [min, mean, 50, 90, 95, 99, max]  100.228ms, 110.681ms, 100.81ms, 125.269ms, 198.536ms, 246.384ms, 275.363ms
Bytes In      [total, mean]                     10230000, 341.00
Bytes Out     [total, mean]                     0, 0.00
Success       [ratio]                           100.00%
Status Codes  [code:count]                      200:30000  
```

# on Mac More than 1000RPS gives error on descriptors side (port allocation)
# running in docker helps to overcome that issue

echo "GET http://localhost:8084/performance-helidon?delay=100" | vegeta attack -duration=60s -rate=1000 | vegeta report

```
Requests      [total, rate, throughput]         60000, 1000.02, 998.33
Duration      [total, attack, wait]             1m0s, 59.999s, 101.256ms
Latencies     [min, mean, 50, 90, 95, 99, max]  100.457ms, 101.09ms, 100.936ms, 101.375ms, 101.879ms, 103.674ms, 130.981ms
Bytes In      [total, mean]                     20460000, 341.00
Bytes Out     [total, mean]                     0, 0.00
Success       [ratio]                           100.00%
Status Codes  [code:count]                      200:60000
```

echo "GET http://localhost:8084/performance-helidon?delay=100" | vegeta attack -duration=60s -rate=2000 | vegeta report

```
Requests      [total, rate, throughput]         120000, 2000.02, 1996.63
Duration      [total, attack, wait]             1m0s, 1m0s, 101.63ms
Latencies     [min, mean, 50, 90, 95, 99, max]  100.354ms, 101.399ms, 101.353ms, 101.59ms, 101.726ms, 104.92ms, 135.186ms
Bytes In      [total, mean]                     40920000, 341.00
Bytes Out     [total, mean]                     0, 0.00
Success       [ratio]                           100.00%
Status Codes  [code:count]                      200:120000
```

echo "GET http://localhost:8084/performance-helidon?delay=100" | vegeta attack -duration=60s -rate=4000 | vegeta report

```
Requests      [total, rate, throughput]         240000, 4000.02, 3993.32
Duration      [total, attack, wait]             1m0s, 1m0s, 100.614ms
Latencies     [min, mean, 50, 90, 95, 99, max]  100.312ms, 101.215ms, 101.047ms, 101.42ms, 101.864ms, 107.301ms, 135.086ms
Bytes In      [total, mean]                     81840000, 341.00
Bytes Out     [total, mean]                     0, 0.00
Success       [ratio]                           100.00%
Status Codes  [code:count]                      200:240000
```
