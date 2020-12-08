
# ewelink-api-java
> eWeLink API written in JAVA

This is a java Libarary based on the ewelink-api node project found here

https://github.com/skydiver/ewelink-api/

All credit goes to them ^^, else this lib would not be possible. Not all features have been added as I dont need them. feel free to submit pull requests.
tried to keep dependencies as small as possible. 

Import

    <dependency>
      <groupId>com.github.realzimboguy.ewelink.api</groupId>
      <artifactId>ewelink-api-java</artifactId>
      <version>2.0.0-RELEASE</version>
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
    
    
            } catch (Exception e) {
                e.printStackTrace();
            }

tags: 
sonoff eweelink api automation java code library
