package com.gateway.app.cucumber.stepdefs;

import com.gateway.app.GatewayApp;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.boot.test.context.SpringBootTest;

@WebAppConfiguration
@SpringBootTest
@ContextConfiguration(classes = GatewayApp.class)
public abstract class StepDefs {

    protected ResultActions actions;

}
