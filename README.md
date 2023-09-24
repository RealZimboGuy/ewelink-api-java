
# ewelink-api-java
> eWeLink API written in JAVA

Website doc: http://ewelink-api-java.co.zw

** 3.0.0-RELEASE ** BREAKING CHANGES prior V2.X.X nolonger working due to ewelik api changes



Import

    <dependency>
      <groupId>com.github.realzimboguy.ewelink.api</groupId>
      <artifactId>ewelink-api-java</artifactId>
      <version>3.0.0-RELEASE</version>
    </dependency>


Usage

Please refer to the Below example, note these are the same details you would login to from the mobile app.
if you get an error on ie "eu" region, try "us" region.

Params for the EWeLink Constructor
- region eg us/eu
- username
- password
- country code **NEW** 
- interval in Minutes for re-login eg, if the api was last called more than 60 min ago, it will perform a login before executing the command.

You must perform a login before calling any other methods, the methods exposed are:

Homepage is the base endpoint that returns all the information about your account, devices, scenes, timers etc.

    public void login() throws Exception

    public Homepage getHomePage() throws Exception 

    public List<Thing> getThings() throws Exception 

    public boolean setDeviceStatus(String deviceId, String status) throws Exception

    public boolean setDeviceStatusByName(String name, String status) throws Exception

sample 

     EweLink eweLink = new EweLink("eu","username@gmail.com","password",60);

        Gson gson = new Gson();
        EweLink eweLink = new EweLink("eu", "test@gmail.com", "test", "+263",60);

        try {
            eweLink.login();

            List<Thing> things = eweLink.getThings();


            logger.info("PRINT DEVICE_ID, NAME, ONLINE, SWITCH, VOLTAGE");
            for (Thing thing : things) {
                logger.info("{}, {}, {}, {}, {}",
                        thing.getItemData().getDeviceid() ,
                        thing.getItemData().getName() ,
                        thing.getItemData().getOnline(),
                        thing.getItemData().getParams().getSwitch(),
                        thing.getItemData().getParams().getVoltage());
            }
            logger.info("PRINT JSON OBJECTS");
            for (Thing thing : things) {
                logger.info("{} ",gson.toJson(thing));
            }

            eweLink.getWebSocket(new WssResponse() {

                @Override
                public void onMessage(String s) {
                    //if you want the raw json data
                    System.out.println("on message in test raw:" + s);

                }

                @Override
                public void onMessageParsed(WssRspMsg rsp) {

                    if (rsp.getError() == null) {

                        //normal scenario
                        StringBuilder sb = new StringBuilder();
                        sb.append("Device:").append(rsp.getDeviceid()).append(" - ");
                        if (rsp.getParams() != null) {
                            sb.append("Switch:").append(rsp.getParams().getSwitch()).append(" - ");
                            sb.append("Voltage:").append(rsp.getParams().getVoltage()).append(" - ");
                            sb.append("Power:").append(rsp.getParams().getPower()).append(" - ");
                            sb.append("Current:").append(rsp.getParams().getCurrent()).append(" - ");
                        }

                        System.out.println(sb.toString());

                    } else if (rsp.getError() == 0) {
                        //this is from a login response
                        System.out.println("login success");
                    } else if (rsp.getError() > 0) {
                        System.out.println("login error:" + rsp.toString());
                    }
                }

                @Override
                public void onError(String error) {
                    System.out.println("onError in test, this should never be called");
                    System.out.println(error);

                }
            });


            Thread.sleep(10000);
            System.out.println(eweLink.setDeviceStatus("1000f40d35", "on"));
            Thread.sleep(5000);
            System.out.println(eweLink.setDeviceStatus("1000f40d35", "off"));




        } catch (Exception e) {
            e.printStackTrace();
        }

tags: 
sonoff eweelink api automation java code library
