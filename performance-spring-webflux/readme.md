# Springboot Netty Webflux 

http://localhost:8082/performance-webflux?delay=100

## Testing with vegeta
On MacBook Pro M2
echo "GET http://localhost:8082/performance-webflux?delay=100" | vegeta attack -duration=60s -rate=500 | vegeta report

```
Requests      [total, rate, throughput]         30000, 500.02, 499.17
Duration      [total, attack, wait]             1m0s, 59.998s, 102.347ms
Latencies     [min, mean, 50, 90, 95, 99, max]  100.26ms, 101.381ms, 101.434ms, 101.772ms, 101.921ms, 102.554ms, 119.58ms
Bytes In      [total, mean]                     10230000, 341.00
Bytes Out     [total, mean]                     0, 0.00
Success       [ratio]                           100.00%
Status Codes  [code:count]                      200:30000  

```

echo "GET http://localhost:8082/performance-webflux?delay=100" | vegeta attack -duration=60s -rate=1000 | vegeta report

```
Requests      [total, rate, throughput]         60000, 1000.02, 998.34
Duration      [total, attack, wait]             1m0s, 59.999s, 100.681ms
Latencies     [min, mean, 50, 90, 95, 99, max]  100.239ms, 101.122ms, 101.226ms, 101.482ms, 101.57ms, 102.204ms, 113.998ms
Bytes In      [total, mean]                     20460000, 341.00
Bytes Out     [total, mean]                     0, 0.00
Success       [ratio]                           100.00%
Status Codes  [code:count]                      200:60000  
```

echo "GET http://localhost:8082/performance-webflux?delay=100" | vegeta attack -duration=60s -rate=2000 | vegeta report

```
Requests      [total, rate, throughput]         120000, 2000.02, 1996.66
Duration      [total, attack, wait]             1m0s, 1m0s, 100.833ms
Latencies     [min, mean, 50, 90, 95, 99, max]  100.119ms, 100.648ms, 100.663ms, 100.891ms, 100.956ms, 101.463ms, 110.282ms
Bytes In      [total, mean]                     40920000, 341.00
Bytes Out     [total, mean]                     0, 0.00
Success       [ratio]                           100.00%
Status Codes  [code:count]                      200:120000  
```

echo "GET http://localhost:8082/performance-webflux?delay=100" | vegeta attack -duration=60s -rate=4000 | vegeta report

```
Requests      [total, rate, throughput]         240000, 4000.02, 3993.33
Duration      [total, attack, wait]             1m0s, 1m0s, 100.451ms
Latencies     [min, mean, 50, 90, 95, 99, max]  100.116ms, 100.374ms, 100.334ms, 100.454ms, 100.506ms, 102.184ms, 134.759ms
Bytes In      [total, mean]                     81840000, 341.00
Bytes Out     [total, mean]                     0, 0.00
Success       [ratio]                           100.00%
Status Codes  [code:count]                      200:240000  
```