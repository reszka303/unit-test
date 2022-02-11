package pl.javastart.mockingintroduction;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SmartHomeControllerTest {

    @DisplayName("should disable watering")
    @Test
    void shouldDisableWatering() {
        // given
        HumiditySensor humiditySensorMock = Mockito.mock(HumiditySensor.class);
        WateringController wateringControllerMock = Mockito.mock(WateringController.class);

        Mockito.when(humiditySensorMock.getHumidity()).thenReturn(50);

        SmartHomeController smartHomeController = new SmartHomeController(humiditySensorMock, wateringControllerMock);

        // when
        smartHomeController.enableWateringIfNeeded();

        // then
        Mockito.verify(wateringControllerMock).disableWatering();
    }

}