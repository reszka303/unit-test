package pl.javastart.creatingmocks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SmartHomeControllerTest {

    @Mock HumiditySensor humiditySensor;
    @Mock WateringController wateringController;

    @InjectMocks
    private SmartHomeController smartHomeController;

// Nie trzeba podawać metody init, ponieważ stosujemy adnotację @InjectMocks
    @BeforeEach
    public void init() {
//        nie trzeba dodawać ↓ bo dodałem MockitoExtension w adnotacji @ExtendWith
//        MockitoAnnotations.openMocks(this);
//nie trzeba dodawać ↓ bo dodałem @InjectMocks, !! jednak w takim wypadku trzeba pamiętać
//czy wszystkie pola konstruktora są wstrzyknięte przez adnotację @Mock (czy są mockowane)
//        smartHomeController = new SmartHomeController(humiditySensor, wateringController);
    }

    @DisplayName("should disable watering")
    @Test
    public void shouldDisableWatering() {
//        HumiditySensor humiditySensorMock = mock(HumiditySensor.class);
//        WateringController wateringControllerMock = mock(WateringController.class);

        // given
//        MockitoAnnotations.openMocks(this);
        Mockito.when(humiditySensor.getHumidity()).thenReturn(50);

//        SmartHomeController smartHomeController = new SmartHomeController(humiditySensor, wateringController);

        // when
        smartHomeController.enableWateringIfNeeded();

        // then
        verify(wateringController).disableWatering();
    }

    @DisplayName("should enable watering")
    @Test
    public void shouldEnableWatering() {
//        HumiditySensor humiditySensorMock = mock(HumiditySensor.class);
//        WateringController wateringControllerMock = mock(WateringController.class);

        // given
//        MockitoAnnotations.openMocks(this);

        Mockito.when(humiditySensor.getHumidity()).thenReturn(49);

//        SmartHomeController smartHomeController = new SmartHomeController(humiditySensor, wateringController);

        // when
        smartHomeController.enableWateringIfNeeded();

        // then
        verify(wateringController).enableWatering();
    }

}