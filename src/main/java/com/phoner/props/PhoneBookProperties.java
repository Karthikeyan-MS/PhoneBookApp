package com.phoner.props;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@EnableConfigurationProperties
@ConfigurationProperties(prefix="phnbook")
@Component
public class PhoneBookProperties {

	private Map<String,String> messages = new HashMap<String,String>();
}
