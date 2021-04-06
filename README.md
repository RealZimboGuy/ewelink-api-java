
# ewelink-api-java
> eWeLink API written in JAVA

Website doc: http://ewelink-api-java.co.zw

This is a java Library based on the ewelink-api node project found here

https://github.com/skydiver/ewelink-api/

All credit goes to them ^^, else this lib would not be possible. Not all features have been added as I dont need them. feel free to submit pull requests.
tried to keep dependencies as small as possible. 

Import

    <dependency>
      <groupId>com.github.realzimboguy.ewelink.api</groupId>
      <artifactId>ewelink-api-java</artifactId>
      <version>2.1.2-RELEASE</version>
    </dependency>


Usage

Please refer to the Below example 

Params for the EWeLink Constructor
- region eg us/eu
- username
- password
- interval in Minutes for re-login eg, if the api was last called more than 60 min ago, it will perform a login before executing the command.

You must perform a login before calling any other methods, the methods exposed are:

    public void login() throws Exception
    
    public Devices getDevices() throws Exception
    
    public DeviceItem getDevice(String deviceId) throws Exception
    
    public Status getDeviceStatus(String deviceId) throws Exception
    
    public Status setDeviceStatusByName(String name, String status) throws Exception
    
    public Status setDeviceStatus(String deviceId, String status) throws Exception
    
    public void getWebSocket(WssResponse wssResponse) throws Exception

sample 

     EweLink eweLink = new EweLink("eu","username@gmail.com","password",60);
    
            try {
                eweLink.login();
                
                Devices getDevices = eweLink.getDevices();
    
                for (DeviceItem devicelist : getDevices.getDevicelist()) {
                    System.out.println(devicelist.getDeviceid());
                    System.out.println(devicelist.getName());
    
                    eweLink.getDeviceStatus(devicelist.getDeviceid());
    
                }
   
                System.out.println(eweLink.getDevice("10009ce53b"));
 
                System.out.println(eweLink.setDeviceStatusByName("Pool Tank","off"));
                
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
    
    
            } catch (Exception e) {
                e.printStackTrace();
            }

tags: 
sonoff eweelink api automation java code library
