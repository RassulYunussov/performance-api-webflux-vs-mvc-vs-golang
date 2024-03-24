# Spring tomcat mvc

http://localhost:8081/performance-mvc?delay=100

## Testing with vegeta
On MacBook Pro M2
echo "GET http://localhost:8081/performance-mvc?delay=100" | vegeta attack -duration=60s -rate=500 | vegeta report

```
Requests      [total, rate, throughput]         30000, 500.02, 499.17
Duration      [total, attack, wait]             1m0s, 59.998s, 101.81ms
Latencies     [min, mean, 50, 90, 95, 99, max]  100.258ms, 101.444ms, 101.482ms, 101.844ms, 101.98ms, 102.771ms, 114.362ms
Bytes In      [total, mean]                     10230000, 341.00
Bytes Out     [total, mean]                     0, 0.00
Success       [ratio]                           100.00%
Status Codes  [code:count]                      200:30000    
```

echo "GET http://localhost:8081/performance-mvc?delay=100" | vegeta attack -duration=60s -rate=1000 | vegeta report

```
Requests      [total, rate, throughput]         60000, 1000.02, 998.34
Duration      [total, attack, wait]             1m0s, 59.999s, 100.873ms
Latencies     [min, mean, 50, 90, 95, 99, max]  100.265ms, 101.172ms, 101.247ms, 101.559ms, 101.653ms, 103.12ms, 126.559ms
Bytes In      [total, mean]                     20460000, 341.00
Bytes Out     [total, mean]                     0, 0.00
Success       [ratio]                           100.00%
Status Codes  [code:count]                      200:60000  
```

echo "GET http://localhost:8082/performance-webflux?delay=100" | vegeta attack -duration=60s -rate=2000 | vegeta report

```
Requests      [total, rate, throughput]         120000, 2000.01, 1974.32
Duration      [total, attack, wait]             1m1s, 1m0s, 780.88ms
Latencies     [min, mean, 50, 90, 95, 99, max]  100.509ms, 525.06ms, 494.309ms, 951.74ms, 1.007s, 1.079s, 1.162s
Bytes In      [total, mean]                     40920000, 341.00
Bytes Out     [total, mean]                     0, 0.00
Success       [ratio]                           100.00%
Status Codes  [code:count]                      200:120000  
```

