package ru.job4j.forum.control;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.PostService;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class PostControlTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    @Test
    @WithMockUser
    public void whenGetCreatePostPage() throws Exception {
        mockMvc.perform(get("/post/create"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post/create"))
                .andExpect(model().attributeExists("user"));
    }

    @Test
    @WithMockUser
    public void whenGetPostPageWithId() throws Exception {
        Post post = Post.of("name", "description", new User());
        post.setId(1);
        when(postService.findPostById(1)).thenReturn(post);
        mockMvc.perform(get("/post?id=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("post",
                        hasProperty("id", is(1))))
                .andExpect(model().attribute("post",
                        hasProperty("name", is("name"))))
                .andExpect(model().attribute("post",
                        hasProperty("description", is("description"))));
    }

    @Test
    @WithMockUser
    public void whenEditPostPageWithId() throws Exception {
        Post post = Post.of("nameedit", "descriptionedit", new User());
        post.setId(1);
        when(postService.findPostById(1)).thenReturn(post);
        mockMvc.perform(get("/post/edit?id=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("post",
                        hasProperty("id", is(1))))
                .andExpect(model().attribute("post",
                        hasProperty("name", is("nameedit"))))
                .andExpect(model().attribute("post",
                        hasProperty("description", is("descriptionedit"))));
    }
}