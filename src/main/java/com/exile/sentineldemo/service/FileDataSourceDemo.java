package com.exile.sentineldemo.service;

import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.datasource.FileRefreshableDataSource;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.csp.sentinel.slots.system.SystemRule;
import com.alibaba.csp.sentinel.slots.system.SystemRuleManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
public class FileDataSourceDemo {

    public static void initFileDataSourceRules() {
        try {
            FileDataSourceDemo demo = new FileDataSourceDemo();
            demo.listenRules();

            /*
             * Start to require tokens, rate will be limited by rule in FlowRule.json
             */
//            FlowQpsRunner runner = new FlowQpsRunner();
//            runner.simulateTraffic();
//            runner.tick();
            log.info("初始化sentinel规则成功");
        } catch (Exception e) {
            log.error("初始化sentinel规则失败");
        }
    }

    private void listenRules() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
//        String flowRulePath = URLDecoder.decode(classLoader.getResource("FlowRule.json").getFile(), "UTF-8");
//        String degradeRulePath = URLDecoder.decode(classLoader.getResource("DegradeRule.json").getFile(), "UTF-8");
//        String systemRulePath = URLDecoder.decode(classLoader.getResource("SystemRule.json").getFile(), "UTF-8");

        // Data source for FlowRule
//        FileRefreshableDataSource<List<FlowRule>> flowRuleDataSource = new FileRefreshableDataSource<>(
//                flowRulePath, flowRuleListParser);
//        FlowRuleManager.register2Property(flowRuleDataSource.getProperty());

        // Data source for DegradeRule
        FileRefreshableDataSource<List<DegradeRule>> degradeRuleDataSource
                = new FileRefreshableDataSource<>(
                new File("src/main/resources/DegradeRule.json"), degradeRuleListParser, 2000, 256, StandardCharsets.UTF_8);
        DegradeRuleManager.register2Property(degradeRuleDataSource.getProperty());

        // Data source for SystemRule
//        FileRefreshableDataSource<List<SystemRule>> systemRuleDataSource
//                = new FileRefreshableDataSource<>(
//                systemRulePath, systemRuleListParser);
//        SystemRuleManager.register2Property(systemRuleDataSource.getProperty());
    }

//    private Converter<String, List<FlowRule>> flowRuleListParser = source -> JSON.parseObject(source,
//            new TypeReference<List<FlowRule>>() {});
    private Converter<String, List<DegradeRule>> degradeRuleListParser = source -> JSON.parseObject(source,
            new TypeReference<List<DegradeRule>>() {});
//    private Converter<String, List<SystemRule>> systemRuleListParser = source -> JSON.parseObject(source,
//            new TypeReference<List<SystemRule>>() {});
}
