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

echo "GET http://localhost:8084/performance-helidon?delay=100" | vegeta attack -duration=60s -rate=1000 | vegeta report

```
Requests      [total, rate, throughput]         60000, 1000.02, 531.54
Duration      [total, attack, wait]             1m0s, 59.999s, 68.009ms
Latencies     [min, mean, 50, 90, 95, 99, max]  302.958µs, 69.899ms, 100.413ms, 101.958ms, 231.423ms, 408.187ms, 627.344ms
Bytes In      [total, mean]                     10887448, 181.46
Bytes Out     [total, mean]                     0, 0.00
Success       [ratio]                           53.21%
Status Codes  [code:count]                      0:125  200:31928  500:27947  
```