package com.macro.client.eurekaclient;

import java.sql.Types;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{
@Autowired
private JdbcTemplate jdbcTemplate;

  @Override
  public String saveCusBaseInfo(Order order) {
    String id = UUID.randomUUID().toString();
    String sql="insert into orders(username, id) values(?, ?)";
    jdbcTemplate.update(sql, new Object[]{order.getUsername(), id}, new int[]{Types.VARCHAR, Types.VARCHAR});
    return id;
  }

  @Override
  public Order searchById(String id) {
    Map<String,Object> map=jdbcTemplate.queryForMap("select * from orders where id = ?", id);
    Order order=new Order();
    //客户ID
    order.setUsername(map.get("username").toString());
    return order;
  }

}
