package dev.ashish.egen;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.ashish.egen.controller.OrderController;
import dev.ashish.egen.model.Order;
import dev.ashish.egen.service.OrderService;
import org.assertj.core.util.DateUtil;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest
public class PostMethodsTest {

    @InjectMocks
    private OrderController orderController;

    @Mock
    private OrderService orderService;

    //@Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup()
    {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(orderController).build();
    }

    @Test
    public void addOrderTest() throws Exception {

        Order order = new Order("placed", "axsdf33",
                DateUtil.parseDatetime("2021-03-31T15:37:41.103+00:00"),
                DateUtil.parseDatetime("2021-03-31T15:37:41.103+00:00"),
                500, 2l);

        MvcResult result = (MvcResult) mockMvc.perform(MockMvcRequestBuilders.post("/egen/addOrder")
                .content(asJsonString(order))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
