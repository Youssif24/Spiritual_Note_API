package ControllersTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spiritual.note.model.entity.User;
import com.spiritual.note.service.UserServices;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.spiritual.note.MainSpringClass.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserServices userServices;

    //convert object as a json string
    ObjectMapper mapper=new ObjectMapper();


    @Test
    public void createUsersTest() throws Exception {
        when(userServices.setUsers()).thenReturn("created");
        mockMvc.perform(get("/api/users/createUsers"))
                .andExpect(status().isCreated())
                .andExpect(content().string("created"));

        //verify that method is called
        verify(userServices).setUsers();
    }

    @Test
    public void saveUserTestAsJson() throws Exception {
        User user=new User();
        user.setName("Kevin");
        user.setAge(27);
        user.setPassword("pass123");

        when(userServices.saveUser(any(User.class))).thenReturn(user);
        mockMvc.perform(post("/api/users/saveUser")
        .contentType(MediaType.APPLICATION_JSON)
        .content(mapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", Matchers.is(user.getName())))
                .andExpect(jsonPath("$.age",Matchers.is(user.getAge())));
    }

    @Test
    public void testFindAllUsers_return_listOf_users() throws Exception {
        List<User> userList=new ArrayList<>();
        userList.add(new User("Garcia","MFC",23));
        userList.add(new User("Freddie","NYC",27));

        when(userServices.getAllUsers()).thenReturn(userList);
        mockMvc.perform(get("/api/users/getAll")
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name",Matchers.is(userList.get(0).getName())))
                .andExpect(jsonPath("$[1].name",Matchers.is(userList.get(1).getName())));
    }


    @Test
    public void testFindUserById_return_user() throws Exception {
        User user0=new User("Victoria","V24",24);

        when(userServices.getUserById(0)).thenReturn(user0);
        mockMvc.perform(get("/api/users/findUser/0")
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",Matchers.is(user0.getName())));
    }
}
