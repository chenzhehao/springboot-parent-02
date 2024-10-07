package com.czh.springboot.controller;

import com.czh.springboot.controller.entity.resp.DDDDomainResp;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.util.BitSet;

@RestController
@RequestMapping("/bloomFilter")
public class BloomFilterController {

    @RequestMapping("/test")
    public int test() {

        BitSet bitSet = new BitSet(10);
        bitSet.set(1000);
        bitSet.get(100);
        bitSet.flip(1000);

        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), 10000000,0.00001d);
        bloomFilter.put(1);
        bloomFilter.put(12);
        bloomFilter.mightContain(1);

        BloomFilter<String> bloomFilterStr = BloomFilter.create(Funnels.stringFunnel(Charset.defaultCharset()), 10000000,0.00001d);
        bloomFilterStr.put("1");
        bloomFilterStr.put("2");
        bloomFilterStr.mightContain("1");


        return 1;
    }

}
