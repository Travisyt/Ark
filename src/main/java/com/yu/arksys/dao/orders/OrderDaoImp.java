package com.yu.arksys.dao.orders;

import com.yu.arksys.bean.OrderRecord;
import com.yu.arksys.service.api.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImp implements OrderDao {

    @Autowired
    private MappingService mappingService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private List<OrderRecord> getOrder(String sql) {
        return jdbcTemplate.query(sql, (resultSet, i) -> new OrderRecord(
                resultSet.getInt("order_id"),
                resultSet.getInt("factory_id"),
                resultSet.getInt("order_status_code"),
                resultSet.getInt("document_id"),
                resultSet.getDate("order_time"),
                resultSet.getDate("arrive_time"),
                resultSet.getDate("pay_time"),
                resultSet.getFloat("benefit"),
                resultSet.getInt("detailed_id"),
                resultSet.getFloat("accounts_payable"),
                resultSet.getFloat("actual_payment")
        ));
    }

    @Override
    public List<OrderRecord> getOrder() {
        String sql = "select * from order";
        return getOrder(sql);
    }

    @Override
    public List<OrderRecord> getOrder(Integer pageSize, Integer pageNum, String orderBy, Boolean desc) {
        Integer startRow = (pageNum - 1) * pageSize;
        String sql = "select * from ";
        return null;
    }

    @Override
    public List<OrderRecord> getOrder(Integer pageSize, Integer pageNum) {
        String sql = "select * from order limit startRow,pageSize";
        int startRow = (pageNum - 1) * pageSize;
        sql = sql.replaceAll("startRow", Integer.toString(startRow)).replaceAll("pageSize", pageSize.toString());
        return getOrder(sql);
    }

    @Override
    public List<OrderRecord> getOrder(Integer pageSize, Integer pageNum, String condition, String orderBy, Boolean desc) {
        int startRow = (pageNum - 1) * pageSize;
        String preSql = "select * from order condition orderBy limit startRow,pageSize";
        String sql = preSql.replaceAll("condition", condition).replaceAll("orderBy", desc ? orderBy + " desc" : orderBy).replaceAll("startRow", Integer.toString(startRow)).replaceAll("pageSize", pageSize.toString());
        return getOrder(sql);
    }

    @Override
    public Integer getCount(String condition) {
        String preSql = "select count(*) from order condition";
        return jdbcTemplate.queryForObject(preSql.replaceAll("condition", condition), Integer.class);
    }

    @Override
    public void delete(Integer orderId) {
        Integer detailedId = jdbcTemplate.queryForObject("select detailed_id from `order` where order_id=" + orderId.toString(), Integer.class);
        assert detailedId != null;
        String sql = "delete from detailed_order where detailed_id=" + detailedId.toString();
        jdbcTemplate.execute(sql);
        sql = "delete from `order` where order_id=" + orderId.toString();
        jdbcTemplate.execute(sql);
    }

    @Override
    public void insert(OrderRecord orderRecord) {
        String sql = "insert into order(order_id,factory_id,order_status_code,document_id,order_time,arrive_time,pay_time,benefit,detailed_id,accounts_payable,actual_payment) values(?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, orderRecord.getOrderId(), orderRecord.getFactoryId(), orderRecord.getOrderStatusCode(), orderRecord.getDocumentId(), orderRecord.getOrderTime(), orderRecord.getArriveTime(), orderRecord.getPayTime(), orderRecord.getBenefit(), orderRecord.getDetailed_id(), orderRecord.getAccountsPayable(), orderRecord.getActualPayment());
    }
}
