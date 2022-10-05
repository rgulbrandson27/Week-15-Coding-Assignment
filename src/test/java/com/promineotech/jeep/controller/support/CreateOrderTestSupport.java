package com.promineotech.jeep.controller.support;

public class CreateOrderTestSupport extends BaseTest{
	protected String createOrderBody() {
//		@formatter: off
		return  "{\n"
			+ "  \"customer\":\"MORISON_LINA\",\n"
			+ "  \"model\":\"COMPASS\",\n"
			+ "  \"trim\":\"Sport\",\n"
			+ "  \"doors\":\"4\",\n"
			+ "  \"color\":\"EXT_JETSET_BLUE\",\n"
			+ "  \"engine\":\"3_0_DIESEL\",\n"
			+ "  \"tire\":\"225_MICHELIN\",\n"
			+ "  \"options\":[\n"
			+ "    \"DOOR_BESTOP_COMBO\",\n"
			+ "	   \"EXT_WARN_BUMPER_FRONT\",\n"
			+ "	   \"EXT_WARN_BUMPER_REAR\"\n"		
			+ "  ]\n"
			+ "}";
//		@formatter: on
	}
}
