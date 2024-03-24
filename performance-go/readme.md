# Go

http://localhost:8083/performance-go?delay=100

## Testing with vegeta
On MacBook Pro M2
echo "GET http://localhost:8083/performance-go?delay=100" | vegeta attack -duration=60s -rate=500 | vegeta report

```
Requests      [total, rate, throughput]         30000, 500.02, 499.18
Duration      [total, attack, wait]             1m0s, 59.998s, 100.677ms
Latencies     [min, mean, 50, 90, 95, 99, max]  100.166ms, 100.539ms, 100.471ms, 100.709ms, 100.864ms, 101.927ms, 114.594ms
Bytes In      [total, mean]                     10260000, 342.00
Bytes Out     [total, mean]                     0, 0.00
Success       [ratio]                           100.00%
Status Codes  [code:count]                      200:30000   

```

echo "GET http://localhost:8083/performance-go?delay=100" | vegeta attack -duration=60s -rate=1000 | vegeta report

```
Requests      [total, rate, throughput]         60000, 1000.02, 998.35
Duration      [total, attack, wait]             1m0s, 59.999s, 100.498ms
Latencies     [min, mean, 50, 90, 95, 99, max]  100.17ms, 100.445ms, 100.408ms, 100.554ms, 100.625ms, 101.316ms, 113.39ms
Bytes In      [total, mean]                     20520000, 342.00
Bytes Out     [total, mean]                     0, 0.00
Success       [ratio]                           100.00%
Status Codes  [code:count]                      200:60000  
```

echo "GET http://localhost:8082/performance-webflux?delay=100" | vegeta attack -duration=60s -rate=2000 | vegeta report

```
Requests      [total, rate, throughput]         120000, 2000.02, 1996.68
Duration      [total, attack, wait]             1m0s, 59.999s, 100.337ms
Latencies     [min, mean, 50, 90, 95, 99, max]  100.134ms, 100.263ms, 100.256ms, 100.295ms, 100.31ms, 100.559ms, 102.115ms
Bytes In      [total, mean]                     41040000, 342.00
Bytes Out     [total, mean]                     0, 0.00
Success       [ratio]                           100.00%
Status Codes  [code:count]                      200:120000  
```

echo "GET http://localhost:8082/performance-webflux?delay=100" | vegeta attack -duration=60s -rate=4000 | vegeta report

```
Requests      [total, rate, throughput]         240000, 4000.02, 3993.35
Duration      [total, attack, wait]             1m0s, 1m0s, 100.15ms
Latencies     [min, mean, 50, 90, 95, 99, max]  100.072ms, 100.153ms, 100.121ms, 100.146ms, 100.181ms, 100.943ms, 108.54ms
Bytes In      [total, mean]                     82080000, 342.00
Bytes Out     [total, mean]                     0, 0.00
Success       [ratio]                           100.00%
Status Codes  [code:count]                      200:240000  
```