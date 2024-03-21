# Helidon SE

http://localhost:8084/performance-helidon?delay=100

## Testing with vegeta
On MacBook Pro M2

echo "GET http://localhost:8084/performance-helidon?delay=100" | vegeta attack -duration=10s -rate=4000 | vegeta report

```
Requests      [total, rate, throughput]         40000, 4000.10, 3956.43
Duration      [total, attack, wait]             10.11s, 10s, 110.36ms
Latencies     [min, mean, 50, 90, 95, 99, max]  100.096ms, 100.464ms, 100.18ms, 100.242ms, 100.479ms, 110.356ms, 134.341ms
Bytes In      [total, mean]                     17520000, 438.00
Bytes Out     [total, mean]                     0, 0.00
Success       [ratio]                           100.00%
Status Codes  [code:count]                      200:40000  
```

