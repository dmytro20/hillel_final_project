package com.hillel.tour.agency.api.service.impl;

import com.hillel.tour.agency.api.entity.Role;
import com.hillel.tour.agency.api.entity.User;
import com.hillel.tour.agency.api.repository.postgre.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest
{
    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp()
        throws Exception
    {
    }

    @Test
    public void get()
    {
    }

    @Test
    public void getUser()
    {
    }

    @Test
    public void save()
    {
    }

    @Test
    public void update()
    {
    }

    @Test
    public void delete()
    {
    }

    @Test
    public void getAll()
    {
        List<User> mockUsers = new ArrayList<>();

        User user = createUser(1, "firstName", "lastName", "login", "password", Role.USER);
        mockUsers.add(user);
        mockUsers.add(createUser(2, "firstName", "lastName", "login1", "password1", Role.USER));

        when(userRepository.findAll()).thenReturn(mockUsers);

        List<User> users = userService.getAll();

        Assert.assertNotNull(users);
        Assert.assertEquals(2, users.size());
        Assert.assertTrue(users.contains(user));
    }

    private User createUser(Integer id, String name, String lastName, String login, String password, Role role)
    {
        return new User().setId(id)
                         .setFirstName(name)
                         .setLastName(lastName)
                         .setPassword(password)
                         .setLogin(login)
                         .setPassword(password)
                         .setRole(role);
    }
}