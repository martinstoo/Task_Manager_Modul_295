package ch.stoyanov.martin.task_manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import ch.stoyanov.martin.task_manager.people.People;
import ch.stoyanov.martin.task_manager.people.PeopleRepository;
import ch.stoyanov.martin.task_manager.people.PeopleService;

class PeopleServiceTests {

    private PeopleService peopleService;
    private final PeopleRepository peopleRepositoryMock = mock(PeopleRepository.class);

    private final People peopleMock = mock(People.class);

    @BeforeEach
    void setUp() {
        peopleService = new PeopleService(peopleRepositoryMock);
    }

    @Test
    void createPeople() {
        when(peopleRepositoryMock.save(peopleMock)).thenReturn(peopleMock);
        peopleService.insertPeople(peopleMock);
        verify(peopleRepositoryMock, times(1)).save(any());
    }

    @Test
    void readPeople() {
        Long peopleId = 1L;
        when(peopleRepositoryMock.findById(peopleId)).thenReturn(Optional.of(peopleMock));

        People retrievedPeople = peopleService.getPeople(peopleId);

        assertEquals(peopleMock, retrievedPeople);
        verify(peopleRepositoryMock, times(1)).findById(peopleId);
    }

    @Test
    void updatePeople() {
        when(peopleRepositoryMock.save(peopleMock)).thenReturn(peopleMock);
        
        People updatedPeople = peopleService.updatePeople(peopleMock, null);
        
        assertEquals(peopleMock, updatedPeople);
        verify(peopleRepositoryMock, times(1)).save(peopleMock);
    }
    
    @Test
    void deletePeople() {
        Long peopleId = 1L;
        doNothing().when(peopleRepositoryMock).deleteById(peopleId);
        
        peopleService.deletePeople(peopleId);
        
        verify(peopleRepositoryMock, times(1)).deleteById(peopleId);
    }
        

}