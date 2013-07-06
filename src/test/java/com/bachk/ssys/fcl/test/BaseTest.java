package com.bachk.ssys.fcl.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)


@ContextConfiguration(locations={"classpath:/app-config.xml", "classpath:/infrastructure-config.xml"})
public class BaseTest {
	
}
