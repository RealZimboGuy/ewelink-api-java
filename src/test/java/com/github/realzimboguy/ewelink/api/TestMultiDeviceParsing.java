package com.github.realzimboguy.ewelink.api;

import com.github.realzimboguy.ewelink.api.model.home.Data;
import com.github.realzimboguy.ewelink.api.model.home.Homepage;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class TestMultiDeviceParsing {



	@Test
	public void testNormalParse() {

		Gson gson = new Gson();


		Homepage home = gson.fromJson(EXAMPLE_NORMAL, Homepage.class);

		System.out.println(home);

		Assert.assertEquals("off",home.getData().getThingInfo().getThingList().get(0).getItemData().getParams().getSwitch());

	}

	@Test
	public void testMultiChannelParse() {

		Gson gson = new Gson();


		Homepage home = gson.fromJson(EXAMPLE_MULTI_CHANNEL, Homepage.class);

		System.out.println(home);

		Assert.assertEquals("off",home.getData().getThingInfo().getThingList().get(0).getItemData().getParams().getSwitches().get(0).get_switch());
		Assert.assertEquals("on",home.getData().getThingInfo().getThingList().get(0).getItemData().getParams().getSwitches().get(1).get_switch());

	}



	public static final String EXAMPLE_MULTI_CHANNEL = "\n" +
			"\n" +
			"\n" +
			"{\n" +
			"   \"error\":0,\n" +
			"   \"msg\":\"\",\n" +
			"   \"data\":{\n" +
			"      \"familyInfo\":{\n" +
			"         \"familyList\":[\n" +
			"            {\n" +
			"               \"id\":\"1111111111\",\n" +
			"               \"apikey\":\"111111\",\n" +
			"               \"name\":\"My Home\",\n" +
			"               \"index\":0,\n" +
			"               \"roomList\":[\n" +
			"                  {\n" +
			"                     \"id\":\"222222\",\n" +
			"                     \"name\":\"Livingroom\",\n" +
			"                     \"index\":0\n" +
			"                  }\n" +
			"               ],\n" +
			"               \"familyType\":1,\n" +
			"               \"members\":[\n" +
			"                  \n" +
			"               ]\n" +
			"            }\n" +
			"         ],\n" +
			"         \"currentFamilyId\":\"12121212\",\n" +
			"         \"hasChangedCurrentFamily\":false\n" +
			"      },\n" +
			"      \"thingInfo\":{\n" +
			"         \"thingList\":[\n" +
			"            {\n" +
			"               \"itemType\":1,\n" +
			"               \"itemData\":{\n" +
			"                  \"name\":\"Outside string\",\n" +
			"                  \"deviceid\":\"222222\",\n" +
			"                  \"apikey\":\"12121212\",\n" +
			"                  \"extra\":{\n" +
			"                     \"uiid\":1\n" +
			"                  },\n" +
			"                  \"brandName\":\"SONOFF\",\n" +
			"                  \"brandLogo\":\"https://eu-ota.coolkit.cc/logo/q62PevoglDNmwUJ9oPE7kRrpt1nL1CoA.png\",\n" +
			"                  \"showBrand\":true,\n" +
			"                  \"devConfig\":{\n" +
			"                     \n" +
			"                  },\n" +
			"                  \"settings\":{\n" +
			"                     \"opsNotify\":0,\n" +
			"                     \"opsHistory\":1,\n" +
			"                     \"alarmNotify\":1,\n" +
			"                     \"wxAlarmNotify\":0,\n" +
			"                     \"wxOpsNotify\":0,\n" +
			"                     \"wxDoorbellNotify\":0,\n" +
			"                     \"appDoorbellNotify\":1\n" +
			"                  },\n" +
			"                  \"devGroups\":[\n" +
			"                     \n" +
			"                  ],\n" +
			"                  \"family\":{\n" +
			"                     \"familyid\":\"12121212\",\n" +
			"                     \"index\":-1,\n" +
			"                     \"members\":[\n" +
			"                        \n" +
			"                     ]\n" +
			"                  },\n" +
			"                  \"shareTo\":[\n" +
			"                     \n" +
			"                  ],\n" +
			"                  \"devicekey\":\"123123123\",\n" +
			"                  \"online\":true,\n" +
			"                  \"params\":{\n" +
			"                     \"bindInfos\":{\n" +
			"                        \n" +
			"                     },\n" +
			"                     \"version\":8,\n" +
			"                     \"only_device\":{\n" +
			"                        \"ota\":\"success\"\n" +
			"                     },\n" +
			"                     \"sledOnline\":\"on\",\n" +
			"                     \"ssid\":\"not-my-real\",\n" +
			"                     \"bssid\":\"00:00:00:00:00:00\",\n" +
			"                        \"switches\":[\n" +
			"                                 {\n" +
			"                                    \"switch\":\"off\",\n" +
			"                                    \"outlet\":0\n" +
			"                                 },\n" +
			"                                 {\n" +
			"                                    \"switch\":\"on\",\n" +
			"                                    \"outlet\":1\n" +
			"                                 },\n" +
			"                                 {\n" +
			"                                    \"switch\":\"off\",\n" +
			"                                    \"outlet\":2\n" +
			"                                 },\n" +
			"                                 {\n" +
			"                                    \"switch\":\"off\",\n" +
			"                                    \"outlet\":3\n" +
			"                                 }\n" +
			"                              ],\n" +
			"                     \"fwVersion\":\"3.7.6\",\n" +
			"                     \"rssi\":-62,\n" +
			"                     \"staMac\":\"11:55:12:12:11:22\",\n" +
			"                     \"startup\":\"off\",\n" +
			"                     \"init\":1,\n" +
			"                     \"pulse\":\"off\",\n" +
			"                     \"pulseWidth\":500,\n" +
			"                     \"rstReason\":4,\n" +
			"                     \"exccause\":0,\n" +
			"                     \"epc1\":0,\n" +
			"                     \"epc2\":0,\n" +
			"                     \"epc3\":0,\n" +
			"                     \"excvaddr\":0,\n" +
			"                     \"depc\":0,\n" +
			"                     \"longOffline\":1\n" +
			"                  },\n" +
			"                  \"denyFeatures\":[\n" +
			"                     \"extSwitchMode\"\n" +
			"                  ],\n" +
			"                  \"isSupportGroup\":true,\n" +
			"                  \"isSupportedOnMP\":true,\n" +
			"                  \"isSupportChannelSplit\":false,\n" +
			"                  \"deviceFeature\":{\n" +
			"                     \n" +
			"                  }\n" +
			"               },\n" +
			"               \"index\":-1\n" +
			"            }\n" +
			"            \n" +
			"         ],\n" +
			"         \"total\":3\n" +
			"      }\n" +
			"   }\n" +
			"}";
	public static final String EXAMPLE_NORMAL = "{\n" +
			"   \"error\":0,\n" +
			"   \"msg\":\"\",\n" +
			"   \"data\":{\n" +
			"      \"familyInfo\":{\n" +
			"         \"familyList\":[\n" +
			"            {\n" +
			"               \"id\":\"1111111111\",\n" +
			"               \"apikey\":\"111111\",\n" +
			"               \"name\":\"My Home\",\n" +
			"               \"index\":0,\n" +
			"               \"roomList\":[\n" +
			"                  {\n" +
			"                     \"id\":\"222222\",\n" +
			"                     \"name\":\"Livingroom\",\n" +
			"                     \"index\":0\n" +
			"                  }\n" +
			"               ],\n" +
			"               \"familyType\":1,\n" +
			"               \"members\":[\n" +
			"                  \n" +
			"               ]\n" +
			"            }\n" +
			"         ],\n" +
			"         \"currentFamilyId\":\"12121212\",\n" +
			"         \"hasChangedCurrentFamily\":false\n" +
			"      },\n" +
			"      \"thingInfo\":{\n" +
			"         \"thingList\":[\n" +
			"            {\n" +
			"               \"itemType\":1,\n" +
			"               \"itemData\":{\n" +
			"                  \"name\":\"Outside string\",\n" +
			"                  \"deviceid\":\"222222\",\n" +
			"                  \"apikey\":\"12121212\",\n" +
			"                  \"extra\":{\n" +
			"                     \"uiid\":1\n" +
			"                  },\n" +
			"                  \"brandName\":\"SONOFF\",\n" +
			"                  \"brandLogo\":\"https://eu-ota.coolkit.cc/logo/q62PevoglDNmwUJ9oPE7kRrpt1nL1CoA.png\",\n" +
			"                  \"showBrand\":true,\n" +
			"                  \"devConfig\":{\n" +
			"                     \n" +
			"                  },\n" +
			"                  \"settings\":{\n" +
			"                     \"opsNotify\":0,\n" +
			"                     \"opsHistory\":1,\n" +
			"                     \"alarmNotify\":1,\n" +
			"                     \"wxAlarmNotify\":0,\n" +
			"                     \"wxOpsNotify\":0,\n" +
			"                     \"wxDoorbellNotify\":0,\n" +
			"                     \"appDoorbellNotify\":1\n" +
			"                  },\n" +
			"                  \"devGroups\":[\n" +
			"                     \n" +
			"                  ],\n" +
			"                  \"family\":{\n" +
			"                     \"familyid\":\"12121212\",\n" +
			"                     \"index\":-1,\n" +
			"                     \"members\":[\n" +
			"                        \n" +
			"                     ]\n" +
			"                  },\n" +
			"                  \"shareTo\":[\n" +
			"                     \n" +
			"                  ],\n" +
			"                  \"devicekey\":\"123123123\",\n" +
			"                  \"online\":true,\n" +
			"                  \"params\":{\n" +
			"                     \"bindInfos\":{\n" +
			"                        \n" +
			"                     },\n" +
			"                     \"version\":8,\n" +
			"                     \"only_device\":{\n" +
			"                        \"ota\":\"success\"\n" +
			"                     },\n" +
			"                     \"sledOnline\":\"on\",\n" +
			"                     \"ssid\":\"not-my-real\",\n" +
			"                     \"bssid\":\"00:00:00:00:00:00\",\n" +
			"                     \"switch\":\"off\",\n" +
			"                     \"fwVersion\":\"3.7.6\",\n" +
			"                     \"rssi\":-62,\n" +
			"                     \"staMac\":\"11:55:12:12:11:22\",\n" +
			"                     \"startup\":\"off\",\n" +
			"                     \"init\":1,\n" +
			"                     \"pulse\":\"off\",\n" +
			"                     \"pulseWidth\":500,\n" +
			"                     \"rstReason\":4,\n" +
			"                     \"exccause\":0,\n" +
			"                     \"epc1\":0,\n" +
			"                     \"epc2\":0,\n" +
			"                     \"epc3\":0,\n" +
			"                     \"excvaddr\":0,\n" +
			"                     \"depc\":0,\n" +
			"                     \"longOffline\":1\n" +
			"                  },\n" +
			"                  \"denyFeatures\":[\n" +
			"                     \"extSwitchMode\"\n" +
			"                  ],\n" +
			"                  \"isSupportGroup\":true,\n" +
			"                  \"isSupportedOnMP\":true,\n" +
			"                  \"isSupportChannelSplit\":false,\n" +
			"                  \"deviceFeature\":{\n" +
			"                     \n" +
			"                  }\n" +
			"               },\n" +
			"               \"index\":-1\n" +
			"            }\n" +
			"            \n" +
			"         ],\n" +
			"         \"total\":3\n" +
			"      }\n" +
			"   }\n" +
			"}";

}
