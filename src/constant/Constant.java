package constant;

public interface Constant {
    //    enum OrderStatus { 取消, 确定, 未生效}
    //订单状态
    /**
     * 已取消
     */
    String SUBSCRIPTION_STATUS_CANCELLED = "3";
    /**
     * 未确认
     */
    String SUBSCRIPTION_STATUS_UNCONFIRMED = "1";
    /**
     * 已确认
     */
    String SUBSCRIPTION_STATUS_CONFIRMED = "2";

    //房间状态
    String ROOM_STATUS_OPEN = "o";
    String ROOM_STATUS_CLOSE ="c";

    //预定方式
    Integer SUBSCRIPTION_METHOD_SINGEL = 1;
    Integer SUBSCRIPTION_METHOD_WHOLE = 2;
}
