package pl.javastart.draganddrop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class AnimalServiceTest {

    @InjectMocks private AnimalService animalService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldCalculateForFirstPosition() {
        // given
        Animal animal1 = createAnimal(1L, "Krowa", 200L);
        Animal animal2 = createAnimal(2L, "Kurczak", 300L);

        List<Animal> animalList = new ArrayList<>(Arrays.asList(animal1, animal2));

        // when
        long sortOrder = animalService.calculateSortOrder(animal2, animalList, 0);

        // then
        assertThat(sortOrder).isEqualTo(100L);
    }

    @Test
    public void shouldCalculateTheSameSortOrderForFirstPosition() {
        // given
        Animal animal1 = createAnimal(1L, "Krowa", 200L);
        Animal animal2 = createAnimal(2L, "Kurczak", 300L);

        List<Animal> animalList = new ArrayList<>(Arrays.asList(animal1, animal2));

        // when
        long sortOrder = animalService.calculateSortOrder(animal2, animalList, 0);

        // then
        assertThat(sortOrder).isEqualTo(100L);
    }


    @Test
    public void shouldCalculateForLastPosition() {
        // given
        Animal animal1 = createAnimal(1L, "Krowa", 200L);
        Animal animal2 = createAnimal(2L, "Kurczak", 300L);

        List<Animal> animalList = new ArrayList<>(Arrays.asList(animal1, animal2));

        // when
        long sortOrder = animalService.calculateSortOrder(animal1, animalList, 1);

        // then
        assertThat(sortOrder).isEqualTo(400L);
    }

    @Test
    public void shouldCalculateTheSameSortOrderForLastPosition() {
        // given
        Animal animal1 = createAnimal(1L, "Krowa", 200L);
        Animal animal2 = createAnimal(2L, "Kurczak", 300L);

        List<Animal> animalList = new ArrayList<>(Arrays.asList(animal1, animal2));

        // when
        long sortOrder = animalService.calculateSortOrder(animal1, animalList, 1);

        // then
        assertThat(sortOrder).isEqualTo(400L);
    }

    @Test
    public void shouldCalculateSortOrderForMidForward() {
        // given
        Animal animal1 = createAnimal(1L, "Krowa", 200L);
        Animal animal2 = createAnimal(2L, "Kurczak", 300L);
        Animal animal3 = createAnimal(3L, "Pies", 400L);

        List<Animal> animalList = new ArrayList<>(Arrays.asList(animal1, animal2, animal3));

        // when
        long sortOrder = animalService.calculateSortOrder(animal1, animalList, 1);

        // then
        assertThat(sortOrder).isEqualTo(350L);
    }

    @Test
    public void shouldCalculateSortOrderForMidBack() {
        // given
        Animal animal1 = createAnimal(1L, "Krowa", 200L);
        Animal animal2 = createAnimal(2L, "Kurczak", 300L);
        Animal animal3 = createAnimal(3L, "Pies", 400L);

        List<Animal> animalList = new ArrayList<>(Arrays.asList(animal1, animal2, animal3));

        // when
        long sortOrder = animalService.calculateSortOrder(animal3, animalList, 1);

        // then
        assertThat(sortOrder).isEqualTo(250L);
    }

    @Test
    public void shouldCalculateSortOrderForMidWithNoPlaces() {
        // given
        Animal animal1 = createAnimal(1L, "Krowa", 250L);
        Animal animal2 = createAnimal(2L, "Kurczak", 251L);
        Animal animal3 = createAnimal(3L, "Pies", 400L);

        List<Animal> animalList = new ArrayList<>(Arrays.asList(animal1, animal2, animal3));

        // when / then
        assertThatThrownBy(() -> animalService.calculateSortOrder(animal3, animalList, 1))
                .isInstanceOf(SortOrderCalculationNotPossibleException.class);

        assertThat(animalList.get(0).getName()).isEqualTo("Krowa");
        assertThat(animalList.get(1).getName()).isEqualTo("Pies");
        assertThat(animalList.get(2).getName()).isEqualTo("Kurczak");
    }

    @Test
    public void shouldReorderList() {
        // given
        Animal animal1 = createAnimal(1L, "Krowa", 250L);
        Animal animal2 = createAnimal(2L, "Kurczak", 251L);
        Animal animal3 = createAnimal(3L, "Pies", 400L);

        List<Animal> animalList = new ArrayList<>(Arrays.asList(animal1, animal2, animal3));

        // when
        animalService.reorderAnimals(animalList);

        // then
        assertThat(animalList.get(0).getSortOrder()).isEqualTo(100L);
        assertThat(animalList.get(1).getSortOrder()).isEqualTo(200L);
        assertThat(animalList.get(2).getSortOrder()).isEqualTo(300L);
    }

    private Animal createAnimal(long id, String name, long sortOrder) {
        Animal animal1 = new Animal();
        animal1.setId(id);
        animal1.setName(name);
        animal1.setSortOrder(sortOrder);
        return animal1;
    }

}