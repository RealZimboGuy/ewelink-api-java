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

Please refer to the TestApp class

     EweLink eweLink = new EweLink("eu","username@gmail.com","password",10);
    
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

