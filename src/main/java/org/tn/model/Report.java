//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
package org.tn.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Class made by the jaxb2-maven-plugin in order to convert XML-entries into Java-objects. Entry that can be added to the POM-file written down below
 */

/*
<plugin>
        <groupId>org.codehaus.mojo</groupId>
        <artifactId>jaxb2-maven-plugin</artifactId>
        <version>2.5.0</version>
        <executions>
          <execution>
            <id>xsd-to-java</id>
            <goals>
              <goal>xjc</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "",
        propOrder = {"deviceInformation", "capture"}
)
@XmlRootElement(
        name = "report"
)
public class Report {
    @XmlElement(
            required = true
    )
    protected DeviceInformation deviceInformation;
    @XmlElement(
            required = true
    )
    protected Capture capture;

    public Report() {
    }

    public DeviceInformation getDeviceInformation() {
        return this.deviceInformation;
    }

    public void setDeviceInformation(DeviceInformation value) {
        this.deviceInformation = value;
    }

    public Capture getCapture() {
        return this.capture;
    }

    public void setCapture(Capture value) {
        this.capture = value;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(
            name = "",
            propOrder = {"listenRange", "deviceStarted", "uptimeSeconds", "updateIntervalMs"}
    )
    public static class DeviceInformation {
        protected int listenRange;
        @XmlElement(
                required = true
        )
        @XmlSchemaType(
                name = "dateTime"
        )
        protected XMLGregorianCalendar deviceStarted;
        protected short uptimeSeconds;
        protected short updateIntervalMs;
        @XmlAttribute(
                name = "deviceId"
        )
        protected String deviceId;

        public DeviceInformation() {
        }

        public int getListenRange() {
            return this.listenRange;
        }

        public void setListenRange(int value) {
            this.listenRange = value;
        }

        public XMLGregorianCalendar getDeviceStarted() {
            return this.deviceStarted;
        }

        public void setDeviceStarted(XMLGregorianCalendar value) {
            this.deviceStarted = value;
        }

        public short getUptimeSeconds() {
            return this.uptimeSeconds;
        }

        public void setUptimeSeconds(short value) {
            this.uptimeSeconds = value;
        }

        public short getUpdateIntervalMs() {
            return this.updateIntervalMs;
        }

        public void setUpdateIntervalMs(short value) {
            this.updateIntervalMs = value;
        }

        public String getDeviceId() {
            return this.deviceId;
        }

        public void setDeviceId(String value) {
            this.deviceId = value;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(
            name = "",
            propOrder = {"drone"}
    )
    public static class Capture {
        protected List<Drone> drone;
        @XmlAttribute(
                name = "snapshotTimestamp"
        )
        @XmlSchemaType(
                name = "dateTime"
        )
        protected XMLGregorianCalendar snapshotTimestamp;

        public Capture() {
        }

        public List<Drone> getDrone() {
            if (this.drone == null) {
                this.drone = new ArrayList();
            }

            return this.drone;
        }

        public XMLGregorianCalendar getSnapshotTimestamp() {
            return this.snapshotTimestamp;
        }

        public void setSnapshotTimestamp(XMLGregorianCalendar value) {
            this.snapshotTimestamp = value;
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(
                name = "",
                propOrder = {"serialNumber", "model", "manufacturer", "mac", "ipv4", "ipv6", "firmware", "positionY", "positionX", "altitude"}
        )
        public static class Drone {
            @XmlElement(
                    required = true
            )
            protected String serialNumber;
            @XmlElement(
                    required = true
            )
            protected String model;
            @XmlElement(
                    required = true
            )
            protected String manufacturer;
            @XmlElement(
                    required = true
            )
            protected String mac;
            @XmlElement(
                    required = true
            )
            protected String ipv4;
            @XmlElement(
                    required = true
            )
            protected String ipv6;
            @XmlElement(
                    required = true
            )
            protected String firmware;
            protected float positionY;
            protected float positionX;
            protected float altitude;

            public Drone() {
            }

            public String getSerialNumber() {
                return this.serialNumber;
            }

            public void setSerialNumber(String value) {
                this.serialNumber = value;
            }

            public String getModel() {
                return this.model;
            }

            public void setModel(String value) {
                this.model = value;
            }

            public String getManufacturer() {
                return this.manufacturer;
            }

            public void setManufacturer(String value) {
                this.manufacturer = value;
            }

            public String getMac() {
                return this.mac;
            }

            public void setMac(String value) {
                this.mac = value;
            }

            public String getIpv4() {
                return this.ipv4;
            }

            public void setIpv4(String value) {
                this.ipv4 = value;
            }

            public String getIpv6() {
                return this.ipv6;
            }

            public void setIpv6(String value) {
                this.ipv6 = value;
            }

            public String getFirmware() {
                return this.firmware;
            }

            public void setFirmware(String value) {
                this.firmware = value;
            }

            public float getPositionY() {
                return this.positionY;
            }

            public void setPositionY(float value) {
                this.positionY = value;
            }

            public float getPositionX() {
                return this.positionX;
            }

            public void setPositionX(float value) {
                this.positionX = value;
            }

            public float getAltitude() {
                return this.altitude;
            }

            public void setAltitude(float value) {
                this.altitude = value;
            }
        }
    }
}
