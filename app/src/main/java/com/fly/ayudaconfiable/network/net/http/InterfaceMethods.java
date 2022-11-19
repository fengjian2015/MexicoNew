package com.fly.ayudaconfiable.network.net.http;

/**
 * nakesoft
 * Created by 孔明 on 2019年7月10日,0010.
 * 158045632@qq.com
 */
public interface InterfaceMethods {

    String serverAddr = "GeneralInterface/";

    /**
     * 根据企业号获取授权
     */
    String getCompCode = serverAddr + "GetAuthorizeByCompCode";
    String newGetCompCode = serverAddr + "NewGetAuthorizeByCompCode";

    /**
     * 操作员登录
     */
    String Login = serverAddr + "Login";

    /**
     * 用户注册
     */
    String Regist = serverAddr + "RegNakeCompInfo";

    /**
     * 发送注册验证码
     */
    String RegistSendCode = serverAddr + "RegCompSendCode";

    /***试用登录**/
    String LoginTrial = serverAddr + "LoginTrial";

    /**
     * 发送验证码
     */
    String RetrievePasswordSendCode = serverAddr + "RetrievePasswordSendCode";

    /**
     * 验证码校验
     */
    String CheckValidationCode = serverAddr + "CheckValidationCode";

    /**
     * 操作员 修改密码
     */
    String RetrievePassword = serverAddr + "RetrievePassword";

    /**
     * 获取店铺信息（用于绑定）
     */
    String GetShopList = serverAddr + "GetShopList";

    /**
     * 获取操作员列表（用于绑定）
     */
    String GetMasterList = serverAddr + "GetMasterList";

    /*** 田高健，改云小二 订单 过滤 **/
    String GetDataAuthMasterList = serverAddr + "GetDataAuthMasterList";

    /**
     * 获取员工分类数据（用于绑定）
     */
    String GetStaffClassList = serverAddr + "GetStaffClassList";

    /**
     * 获取提成员工数据（用于绑定）
     */
    String GetStaffList = serverAddr + "GetStaffList";

    /**
     * 获取优惠活动数据
     */
    String GetActivityList = serverAddr + "GetActivityList";

    /**
     * 自定义字段获取
     */
    String GetCustomFieldList = serverAddr + "GetCustomFieldList";

    /**
     * 获取操作员信息
     */
    String GetMasterInfo = serverAddr + "GetMasterInfo";

    /**
     * 获取积分变动类型
     */
    String GetPointChangeType = serverAddr + "GetPointChangeType";

    /**
     * 修改操作员密码
     */
    String ModifyMasterPassword = serverAddr + "ModifyMasterPassword";

    /**
     * 获取产品分类信息
     */
    String GetGoodsClassList = serverAddr + "GetGoodsClassList";
    /*后厨设置中设备获取商品分类*/
    String BindSelParentGoodsClassList = serverAddr + "BindSelParentGoodsClassList";

    /**
     * 获取服务产品分页数据
     */
    String GetServiceGoodsPage = serverAddr + "GetServiceGoodsPage";  //废了

    /**
     * 根据产品ID获取产品数据
     */
    String GetGoodsByID = serverAddr + "GetGoodsByID";

    /***获取等级信息（用于绑定）*/
    /*会员筛选时调用*/
    String BindMemLevelList = serverAddr + "BindMemLevelList";
    /*会员注册时调用*/
    String BindMemRegLevelList = serverAddr + "BindMemRegLevelList";
    /*变更会员等级时调用*/
    String GetMemLevelList = serverAddr + "GetMemLevelList";

    /**
     * 根据ID获取等级信息
     */
    String GetMemLevelByID = serverAddr + "GetMemLevelByID";

    /**
     * 保存会员等级信息
     */
    String SaveMemLevel = serverAddr + "SaveMemLevel";

    /**
     * 删除会员等级
     */
    String DeleteMemLevel = serverAddr + "DeleteMemLevel";

    /**
     * 保存特殊折扣
     */
    String SaveClassDiscountRulesList = serverAddr + "SaveClassDiscountRulesList";

    /**
     * 获取推荐设置
     */
    String GetRecommendedSet = serverAddr + "GetRecommendedSet";

    /**
     * 获取系统参数
     */
    String GetSysArgument = serverAddr + "GetSysArgument";

    /**
     * 参数设置保存
     */
    String SaveSysArgument = serverAddr + "SaveSysArgument";

    /**
     * 会员信息查询(收银、列表)
     */
    String SearchMemCardList = serverAddr + "SearchMemCardList";

    /**
     * 保存会员信息
     */
    String SaveMemberData = serverAddr + "SaveMemberData";
    /*新接口*/
    String SaveMemberManagement = serverAddr + "SaveMemberManagement";

    /**
     * 删除会员
     */
    String DeleteMemberData = serverAddr + "DeleteMemberData";

    /**
     * 上传图片 base64
     */
    String UploadImg = serverAddr + "UploadImg";

    /**
     * 会员换卡
     */
    String MemChangeCardID = serverAddr + "MemChangeCardID";

    /**
     * 会员修改密码
     */
    String MemUpdatePassword = serverAddr + "MemUpdatePassword";

    /**
     * 会员积分调整
     */
    String MemPointAdjust = serverAddr + "MemPointAdjust";

    /**
     * 会员解锁/解锁
     */
    String MemLockSet = serverAddr + "MemLockSet";

    /**
     * 获取商品列表分页数据
     **/
    String GetGoodsListPage = serverAddr + "GetGoodsListPage";

    /**
     * 获取商品分页数据（收银）
     **/
    String GetCashierGoodsListPage = serverAddr + "GetCashierGoodsListPage";

    /**
     * 保存商品
     **/
    String SaveGoodsData = serverAddr + "SaveGoodsData";

    /**
     * 获取优惠券分页数据
     **/
    String GetConponListPage = serverAddr + "GetConponListPage";

    /**
     * 获取今日业绩详情
     */
//    String GetAppDailyStatementStatisticsData = serverAddr + "GetAppDailyStatementStatisticsData";
    String GetAppDailyStatementStatisticsDataNew = serverAddr + "GetAppDailyStatementStatisticsDataNew";

    /*** 保存操作员信息 */
    String SaveMasterData = serverAddr + "SaveMasterData";

    /**
     * 获取交班数据
     */
    String GetShiftTurnOverData = serverAddr + "GetShiftTurnOverData";

    /**
     * 保存交班数据
     */
    String SaveShiftTurnOverData = serverAddr + "SaveShiftTurnOverData";

    /**
     * 获取今日业绩详情
     */
    String GetAppDailyStatementStatisticsData = serverAddr + "GetAppDailyStatementStatisticsData";

    /**
     * 提交意见反馈
     */
    String SaveUserFeedBackData = serverAddr + "SaveUserFeedBackData";

    /*** 快速消费、固定消费*/
    String QuickConsume = serverAddr + "QuickConsume";

    /**
     * 商品消费、计次消费、套餐消费、快速扣次
     */
    String GoodsConsume = serverAddr + "GoodsConsume";

    /**** 计算订单优惠券优惠金额 */
    String CalculateConponAmount = serverAddr + "CalculateConponAmount";

    /***消费记录*/
    String GetConsumeOrderList = serverAddr + "GetConsumeOrderList";
    /****单据里面的油品与非油品单据*/
    String GetOilsConsumeOrderPage = serverAddr + "GetOilsConsumeOrderPage";
    String GetNoOilsConsumeOrderPage = serverAddr + "GetNoOilsConsumeOrderPage";

    /***单据管理-消费订单详情**/
    String GetConsumeOrderData = serverAddr + "GetConsumeOrderData";

    /***单据管理-充次订单详情**/
    String GetRechargeCountOrderByDetail = serverAddr + "GetRechargeCountOrderByDetail";

    /***单据管理-兑换订单详情**/
    String GetRedeemOrderByDetail = serverAddr + "GetRedeemOrderByDetail";

    /***单据管理-会员卡订单详情**/
    String GetMemCardOrderByDetail = serverAddr + "GetMemCardOrderByDetail";

    /**
     * 消费撤单：快速消费、商品消费、固定消费、快速扣次、房台开单、油品消费
     */
    String RevokeConsumeOrder = serverAddr + "RevokeConsumeOrder";

    /*** 消费退货 */
    String MemberReturnGoods = serverAddr + "MemberReturnGoods";

    /*** 场地退货 */
    String RefundVenueConsume = serverAddr + "RefundVenueConsume";

    /***消费挂单 */
    String RestingConsume = serverAddr + "RestingConsume";

    /***消费挂单列表**/
    String GetRestingOrderList = serverAddr + "GetRestingOrderList";

    /**
     * 取单-消费挂单详情
     **/
    String GetRestingOrderData = serverAddr + "GetRestingOrderData";

    /**
     * 获取套餐列表
     **/
    String GetComboListPage = serverAddr + "GetComboListPage";

    /*** 获取套餐详情 */
    String GetComboData = serverAddr + "GetComboData";

    /**
     * 获取积分兑换礼品列表
     */
    String GetGiftInfoPage = serverAddr + "GetGiftInfoPage";

    /*** 获取订单列表 */
    String GetMallOrderListPage = serverAddr + "GetMallOrderListPage";

    /**
     * 获取订单详情
     **/
    String GetOrderDetail = serverAddr + "GetMallOrderDetail";
    String GetPreWriteOffOrder = serverAddr + "GetPreWriteOffOrder";

    /**
     * 拒绝退款
     */
    String MallOrderRefuseRefund = serverAddr + "MallOrderRefuseRefund";

    /**
     * 商品核销、订单核销
     **/
    String OrderWriteOff = serverAddr + "WriteOffMallOrder";

    /**
     * 同意退款
     **/
    String GgreeConsumeOrder = serverAddr + "RevokeConsumeOrder";

    /*** 获取物流公司列表 */
    String GetLogistList = serverAddr + "GetExpressList";

    /**
     * 订单确认发货
     **/
    String SureSendOut = serverAddr + "DeliverMallOrder";

    /**
     * 查询快递信息 目前下单可选普通快递（也是默认） 还有同城配送和上门自提 只有默认的普通快递才具备物流信息
     **/
    String GetLogistTranseInfo = serverAddr + "GetExpressInfo";

    /***积分变动记录（分页）*/
    String GetPointLogByPaged = serverAddr + "GetPointLogByPaged";

    /***APP报表首页统计*/
    String GetAppReportIndexDailyStatementStatisticsData = serverAddr + "GetAppReportIndexDailyStatementStatisticsData";

    /**
     * 近7日销售情况
     **/
    String GetAppNearSevenDaysConsumeStatementStatisticsData = serverAddr + "GetAppNearSevenDaysConsumeStatementStatisticsData";

    /***获取优惠活动数据 */
    String GetActivityListPage = serverAddr + "GetActivityListPage";

    /***保存优惠活动**/
//    String SaveActivityData = serverAddr + "SaveActivityData";
    String AppSaveActivityData = serverAddr + "AppSaveActivityData";

    /***删除优惠活动*/
    String DeleteActivity = serverAddr + "DeleteActivity";

    /***保存优惠券数据*/
    String SaveConponData = serverAddr + "SaveConponData";

    /***获取会员优惠券*/
    String GetConponLogListPage = serverAddr + "GetConponLogListPage";

    /***获取会员优惠券*/
    String GetMemConponList = serverAddr + "GetMemConponList";

    /***优惠券核销**/
    String WriteOffCoupon = serverAddr + "WriteOffCoupon";

    /*** 短信模板列表**/
    String GetSMSMsgTemplateList = serverAddr + "GetSMSMsgTemplateList";

    /***短信自定义模板（增、改）**/
    String SaveSMSMsgTemplate = serverAddr + "SaveSMSMsgTemplate";

    /**
     * 短信自定义模板（删除）
     **/
    String DeleteSMSMsgTemplate = serverAddr + "DeleteSMSMsgTemplate";

    /***发送短信*/
    String SmsSend = serverAddr + "SmsSend";

    /***获取会员详情**/
    String GetMemDataByID = serverAddr + "GetMemDataByID";

    /***会员充次**/
    String RechargeCount = serverAddr + "RechargeCount";

    /***会员礼品兑换*/
    String RedeemGift = serverAddr + "RedeemGift";

    /***单据管理-礼品兑换订单**/
    String GetRedeemOrderByPaged = serverAddr + "GetRedeemOrderByPaged";

    /**
     * 单据管理-会员卡订单
     */
    String GetMemCardOrderByPaged = serverAddr + "GetMemCardOrderByPaged";

    /*** 会员充值 */
    String TopUp = serverAddr + "TopUp";

    /***单据管理-会员充值 */
    String GetTopUpOrderByPaged = serverAddr + "GetTopUpOrderByPaged";

    /****单据管理-充值订单详情*/
    String GetTopUpOrderByDetail = serverAddr + "GetTopUpOrderByDetail";

    /****充值撤单 */
    String RevokeTopUpOrder = serverAddr + "RevokeTopUpOrder";

    /***充值重打印*/
    String TopUpOrderRePrint = serverAddr + "TopUpOrderRePrint";

    /***获取充次商品分页数据*/
    String GetRechargeCountGoodsListPage = serverAddr + "GetRechargeCountGoodsListPage";

    /**
     * 获取今日业绩详情
     **/
    String GetTodayStatementStatisticsData = serverAddr + "GetTodayStatementStatisticsData";

    /**
     * 获取优惠活动选择（不分页）
     **/
    String BindActivityListSelect = serverAddr + "BindActivityListSelect";

    /**
     * 保存商品分类
     */
    String SaveGoodsClassData = serverAddr + "SaveGoodsClassData";

    /**
     * 删除商品分类
     **/
    String DeleteGoodsClass = serverAddr + "DeleteGoodsClass";

    /**
     * 调整会员等级
     */
    String UpdateMemberLevel = serverAddr + "UpdateMemberLevel";

    /*** 保存套餐 **/
    String SaveComboData = serverAddr + "SaveComboData";

    /**
     * 删除套餐
     **/
    String DeleteComboData = serverAddr + "DeleteComboData";

    /*** 支付接口 ***/
    String ComboBarcodePay_API = serverAddr + "ComboBarcodePay";
    String QueryPay_API = serverAddr + "QueryPay";
    String Refund_API = serverAddr + "Refund";
    String QueryPayByBarcodePay = serverAddr + "QueryPayByBarcodePay";

    /*** 支付流程变更 增加接口****/
    /**
     * 创建临时订单
     **/
    String ComboBarcodePayCreateTemp = serverAddr + "ComboBarcodePayCreateTemp";
    /**
     * 更新临时表信息
     **/
    String ComboBarcodePayNew = serverAddr + "ComboBarcodePayByTempOrder";
    /*** 删除临时表数据 **/
    String DeleteOrderTemp = serverAddr + "DeleteOrderTemp";

    /***删除商品  **/
    String DeleteGoods = serverAddr + "DeleteGoods";

    /**
     * 获取商品规格键列表
     */
    String GetGoodsSpecsKeyPage = serverAddr + "GetGoodsSpecsKeyPage";

    /**
     * 获取商品规格键列表(不分页，用于选择绑定)
     */
    String GetGoodsSpecsKeyList = serverAddr + "GetGoodsSpecsKeyList";

    /**
     * 保存商品规格键
     */
    String SaveGoodsSpecsKeyInfo = serverAddr + "SaveGoodsSpecsKeyInfo";

    /**
     * 删除商品规格键
     */
    String DeleteGoodsSpecsKeyInfo = serverAddr + "DeleteGoodsSpecsKeyInfo";

    /**
     * 获取商品规格值列表
     */
    String GetGoodsSpecsValueList = serverAddr + "GetGoodsSpecsValueList";

    /**
     * 保存商品规格值
     */
    String SaveGoodsSpecsValue = serverAddr + "SaveGoodsSpecsValue";

    /**
     * 删除商品规格值
     */
    String DeleteGoodsSpecsValueInfo = serverAddr + "DeleteGoodsSpecsValueInfo";

    /**
     * 获取商品单位（新增商品时选择）
     */
    String GetGoodsUnitList = serverAddr + "GetGoodsUnitList";

    /**
     * 获取供应商数据（新增商品时选择）
     */
    String GetSupplierList = serverAddr + "GetSupplierList";

    /**
     * 获取套餐选择商品列表分页数据（新增编辑套餐时）
     */
    String GetComboGoodsListPage = serverAddr + "GetComboGoodsListPage";

    /**
     * 获取商品规格价格及库存（多规格商品加入购物车时）
     */
    String GetGoodsSpecsInfo = serverAddr + "GetGoodsSpecsInfo";

    /**
     * 检查多规格产品库存（修改多规格商品时，有库存多不能删除）
     */
    String CheckGoodsSpecsStock = serverAddr + "CheckGoodsSpecsStock";

    /**
     * 进货/盘点查找商品
     */
    String GetStockGoodsList = serverAddr + "GetStockGoodsList";

    /**
     * 商品进货
     */
    String GoodsStockIn = serverAddr + "GoodsStockIn";

    /**
     * 商品盘点
     */
    String GoodsInventory = serverAddr + "GoodsInventory";

    /**
     * 补单
     */
    String OrderSupplement = serverAddr + "OrderSupplement";

    /**
     * 会员消费验证密码
     */
    String CheckMemberPwd = serverAddr + "CheckMemberPwd";

    /**
     * 计次套餐延期
     */
    String CHANGE_EXPIRE_TIME = serverAddr + "DelayMemberCountCard";

    /**
     * 根据店铺获取短信数量
     */
    String GetShopMessageNumber = serverAddr + "GetShopMessageNumber";
    String GetFixedOrderList = serverAddr + "GetFixedOrderList";

    /**
     * 固定消费前20条记录
     */
    String GetFixedMoneyOrderList = serverAddr + "GetFixedMoneyOrderList";

    /**
     * 固定消费
     */
    String FixedConsume = serverAddr + "FixedConsume";

    /**
     * 固定扣次记录
     */
    String GetFixedCountOrderList = serverAddr + "GetFixedCountOrderList";

    /**
     * 固定扣次
     */
    String SaveSpeedCountOrder = serverAddr + "SaveSpeedCountOrder";

    /***充次单据*/
    String GetRechargeCountOrderByPaged = serverAddr + "GetRechargeCountOrderByPaged";

    /**
     * 单据管理-充次订单重打印
     */
    String RechargeCountOrderRePrint = serverAddr + "RechargeCountOrderRePrint";

    /**
     * 单据管理-礼品兑换订单重打印
     */
    String RedeemOrderRePrint = serverAddr + "RedeemOrderRePrint";

    /**
     * 单据管理-会员卡订单重打印
     */
    String MemCardOrderRePrint = serverAddr + "MemCardOrderRePrint";

    /**
     * 单据管理-消费订单重打印
     */
    String ConsumeOrderRePrint = serverAddr + "ConsumeOrderRePrint";

    /***单据管理-会员卡订单撤单*/
    String RevokeMemCardOrder = serverAddr + "RevokeMemCardOrder";

    /***积分兑换撤单 */
    String RevokeRedeemOrder = serverAddr + "RevokeRedeemOrder";

    /***充次撤单 */
    String RevokeRechargeCountOrder = serverAddr + "RevokeRechargeCountOrder";

    /*** 获取商品消费退货支付退款信息 */
    String GetReturnGoodsPayments = serverAddr + "GetReturnGoodsPayments";

    /***场地退款信息查询*/
    String GetReturnVenueConsumePayments = serverAddr + "GetReturnVenueConsumePayments";

    /***删除挂单数据*/
    String CancelRestingOrder = serverAddr + "CancelRestingOrder";

    /***获取会员挂单数据*/
    String GetMemberRestingOrder = serverAddr + "GetMemberRestingOrder";

    /***获取主界面成功案例列表*/
    String GetTopSuccessStory = serverAddr + "GetTopSuccessStory";

    /***获取注册界面需要的行业列表*/
    String GetNakeSoftVersion = serverAddr + "GetNakeSoftVersion";

    /***获取支出列表*/
    String GetOutlayLogPageList = serverAddr + "GetOutlayLogPageList";

    /***获取支出分类列表*/
    String GetOutLayCateList = serverAddr + "GetOutLayCateList";

    /***新增分类*/
    String AddOutLayCate = serverAddr + "AddOutLayCate";

    /***获取图标*/
    String GetOutlayCateIcon = serverAddr + "GetOutlayCateIcon";

    /***删除分类*/
    String DeleteOutLayCate = serverAddr + "DeleteOutLayCate";

    /***编辑分类*/
    String UpdateOutLayCate = serverAddr + "UpdateOutLayCate";

    /***新增支出记录*/
    String AddOutLaLog = serverAddr + "AddOutLaLog";

    /***支出详情*/
    String GetOutLayLog = serverAddr + "GetOutLayLog";

    /***删除支出*/
    String DeleteOutLayLog = serverAddr + "DeleteOutLayLog";

    /***编辑支出*/
    String UpdateOutLayLog = serverAddr + "UpdateOutLayLog";

    /***获取油枪列表**/
    String GetOilsGunList = serverAddr + "GetOilsGunList";

    /***获取油枪折扣**/
    String GetOilsDiscount = serverAddr + "GetOilsDiscount";
    String FindConsumeOilsDiscountInfo = serverAddr + "FindConsumeOilsDiscountInfo";

    /***根据车牌号查询会员**/
    String GetMemByPlateNumber = serverAddr + "GetMemByPlateNumber";

    /***油品结算**/
    String OILCHANGE = serverAddr + "OilsConsume";

    /**** 计算油品优惠券优惠金额 */
    String CalculateOilsConponAmount = serverAddr + "CalculateOilsConponAmount";

    /*** 保存修改企业信息 */
    String SaveCompAdminPwd = serverAddr + "SaveCompAdminPwd";

    /*账户安全管理下次提醒*/
    String SaveCompAdminPwdNextTime = serverAddr + "SaveCompAdminPwdNextTime";

    /***获取油品优惠券*/
    String GetMemOilsConpon = serverAddr + "GetMemOilsConpon";

    /*获取商品规格*/
//    String GetGoodsSpecsInfoNew = serverAddr + "GetGoodsSpecsInfoNew";
    String NewGetGoodsSpecsInfo = serverAddr + "NewGetGoodsSpecsInfo";

    /***点餐获取所有设备列表*/
    String GetEquipmentPage = serverAddr + "GetEquipmentPage";
    /***排队设置、叫号所有设备列表*/
    String GetRestaurantEquipment = serverAddr + "GetRestaurantEquipment";

    /***点餐获取设备品牌*/
    String GetEquipmentBrandList = serverAddr + "GetEquipmentBrandList";

    /***点餐保存设备信息*/
    String SaveEquipmentInfo = serverAddr + "SaveEquipmentInfo";

    /***点餐删除设备*/
    String DelEquipmentInfo = serverAddr + "DelEquipmentInfo";

    /***点餐获取二维码列表*/
    String GetRestaurantQRCodePage = serverAddr + "GetRestaurantQRCodePage";

    /***点餐获取规则配置*/
    String SaveRestaurantConfig = serverAddr + "SaveRestaurantConfig";

    /***点餐订单列表*/
    String GetRestaurantOrderPage = serverAddr + "GetRestaurantOrderPage";

    /***点餐消费**/
    String RestaurantConsume = serverAddr + "RestaurantConsume";

    /***排队叫号获取规则配置*/
    String GetChowlineConfig = serverAddr + "GetChowlineConfig";

    /***排队叫号保存规则配置*/
    String SaveChowlineConfig = serverAddr + "SaveChowlineConfig";

    /***排队叫号获取分类列表*/
    String GetChowlineClassifyList = serverAddr + "GetChowlineClassifyList";

    /***排队叫号保存分类*/
    String SaveChowlineClassify = serverAddr + "SaveChowlineClassify";

    /***排队叫号删除分类*/
    String DelChowlineClassify = serverAddr + "DelChowlineClassify";

    /***排队叫号获取取号列表*/
    String GetChowlineOrderPage = serverAddr + "GetChowlineOrderPage";

    /***排队叫号获取历史订单列表*/
    String GetHistoryChowlineOrderPage = serverAddr + "GetHistoryChowlineOrderPage";

    /***排队叫号取号*/
    String ChowlineOrderConsume = serverAddr + "ChowlineOrderConsume";

    /***排队叫号叫号*/
    String ChowlineOrderForCall = serverAddr + "ChowlineOrderForCall";

    /***排队叫号就餐/过号*/
    String ChowlineOrderForStatus = serverAddr + "ChowlineOrderForStatus";

    /***排队叫号全部过号*/
    String ChowlineOrderForOutAll = serverAddr + "ChowlineOrderForOutAll";

    /***聚合支付*/
    String OnlinePayTempOrder = serverAddr + "OnlinePayTempOrder";
    String OnlinePrePayByBarcodePay = serverAddr + "OnlinePrePayByBarcodePay";

    /***商品条码库之商品识别*/
    String GetBarCodeInfo = serverAddr + "GetBarCodeInfo";

    /***会员最近一笔消费*/
    String FindOilsConsumeOrderInfoByMember = serverAddr + "FindOilsConsumeOrderInfoByMember";

    /***会员最近一笔消费*/
    String GetOilsConsumeOrderInfoPageByMember = serverAddr + "GetOilsConsumeOrderInfoPageByMember";

    /***搜寻匿名优惠券*/
    String FindConsumeConponInfo = serverAddr + "FindConsumeConponInfo";

    /***取消花呗分期支付*/
    String CancelPay = serverAddr + "CancelPay";

    /*** 商品上下架 *****/
    String MPSetShelvesStatus = serverAddr + "MPSetShelvesStatus";

    /***后厨设置页面数据*/
    String FindBackKitchenConfigInfo = serverAddr + "FindBackKitchenConfigInfo";

    /***设备列表*/
    String BindSelEquipmentList = serverAddr + "BindSelEquipmentList";

    /***保存后厨设置*/
    String SaveRestaurantBackKitchenConfig = serverAddr + "SaveRestaurantBackKitchenConfig";

    /***普通商品系统规格组*/
    String GetGoodsFlavorTemplatePage = serverAddr + "GetGoodsFlavorTemplatePage";

    /***口味规格*/
    String GetGoodsFlavorListByGoodsID = serverAddr + "GetGoodsFlavorListByGoodsID";

    /***点餐订单解锁*/
    String UnLockRestaurantAddFoodOrder = serverAddr + "UnLockRestaurantAddFoodOrder";

    /***点餐订单叫号*/
    String OperateRestaurantOrderCallNo = serverAddr + "OperateRestaurantOrderCallNo";

    /***操作点餐订单 1接单 2出餐 3撤单 4拒单*/
    String OperateRestaurantOrderStatus = serverAddr + "OperateRestaurantOrderStatus";

    /***点餐订单详情*/
    String FindRestaurantOrderDetailInfo = serverAddr + "FindRestaurantOrderDetailInfo";

    /***退菜*/
    String OperateRestaurantOrderRefundGoods = serverAddr + "OperateRestaurantOrderRefundGoods";

    /***点餐订单列表单条打印*/
    String OperateRestaurantOrderPrint = serverAddr + "OperateRestaurantOrderPrint";

    /***删除点餐二维码*/
    String DeleteRestaurantQRCode = serverAddr + "DeleteRestaurantQRCode";

    /***保存点餐规则*/
    String SaveRestaurantRule = serverAddr + "SaveRestaurantRule";

    /***新增二维码保存*/
    String SaveRestaurantQRCode = serverAddr + "SaveRestaurantQRCode";

    /***验证二维码*/
    String CheckQRCodeNumber = serverAddr + "CheckQRCodeNumber";

    /***获取房台的地区列表数据*/
    String GetRoomRegionList = serverAddr + "GetRoomRegionList";

    /***房台管理区域列表*/
    String PCGetRoomRegionList = serverAddr + "PCGetRoomRegionList";

    /***新增货编辑房台的保存*/
    String PCSaveRoomInfo = serverAddr + "PCSaveRoomInfo";

    /***房台管理地区对应的当前房台数据*/
    String PCGetRoomInfoList = serverAddr + "PCGetRoomInfoList";

    /***当前正在管理的房台的房台信息*/
    String PCFindRoomInfo = serverAddr + "PCFindRoomInfo";

    /***删除房台*/
    String PCDelRoomInfo = serverAddr + "PCDelRoomInfo";

    /***删除房台区域*/
    String PCDelRoomRegionInfo = serverAddr + "PCDelRoomRegionInfo";

    /***新增与编辑房台区域*/
    String PCSaveRoomRegionInfo = serverAddr + "PCSaveRoomRegionInfo";

    /***获取对应地区的房台数据*/
    String GetAllRoomRestingOrderList = serverAddr + "GetAllRoomRestingOrderList";

    /***取消房台当前挂单*/
    String CancelRoomRestingOrder = serverAddr + "CancelRestingOrder";

    /***房台的占用与取消占用*/
    String ModifyRoomState = serverAddr + "ModifyRoomState";

    /***获取该房台的排单列表*/
    String GetRoomRestingOrderList = serverAddr + "GetRoomRestingOrderList";

    /***获取当前手牌的具体挂单数据*/
    String GetRoomRestingOrderDetailList = serverAddr + "GetRoomRestingOrderDetailList";

    /***切换房台*/
    String SwitchRoom = serverAddr + "SwitchRoom";

    /***普通消费挂单 包括房台和手牌（APP现在还没有手牌）*/
    String SaveRestingOrder = serverAddr + "SaveRestingOrder";

    /***点餐订单挂单*/
    String SaveRestaurantRestingOrder = serverAddr + "SaveRestaurantRestingOrder";

    /***房台、手牌等的挂单数据*/
    String GetRestingOpenOrderData = serverAddr + "GetRestingOpenOrderData";

    /***锁定菜单*/
    String LockRestaurantAddFoodOrder = serverAddr + "LockRestaurantAddFoodOrder";

    /***点餐订单消费*/
    String RestaurantGoodsConsume = serverAddr + "RestaurantGoodsConsume";

    /***获取统计报表中的会员数据*/
    String GetMemClassList = serverAddr + "GetMemClassList";

    /***获取统计报表中的计次数据*/
    String GetMeteringClassList = serverAddr + "GetMeteringClassList";

    /***获取统计报表中的商品数据*/
    String GetGoodClassList = serverAddr + "GetGoodClassList";

    /***获取预约项目*/
    String GetCashierReservationItemPage = serverAddr + "GetCashierReservationItemPage";

    /***获取预约服务员工*/
    String GetReservationTechnicianTime = serverAddr + "GetReservationTechnicianTime";

    /***获取预约订单列表*/
    String GetReservationOrderPage = serverAddr + "GetReservationOrderPage";

    /***获取预约订单详情*/
    String FindReservationOrderInfo = serverAddr + "FindReservationOrderInfo";

    /***取消预约订单*/
    String CancelReservationOrder = serverAddr + "CancelReservationOrder";

    /***获取预约开单数据*/
    String FindReservationOpenOrderInfo = serverAddr + "FindReservationOpenOrderInfo";

    /***保存新增编辑预约*/
    String SaveReservationOrderInfo = serverAddr + "SaveReservationOrderInfo";

    /***获取预约是否需要服务员工*/
    String FindReservationIsStaffAppointment = serverAddr + "FindReservationIsStaffAppointment";

    /***获取预约时间*/
    String GetReservationItemIntervalTime = serverAddr + "GetReservationItemIntervalTime";

    /***获取可预约时间信息*/
    String FindReservationTimeLimitInfo = serverAddr + "FindReservationTimeLimitInfo";

    /***查询打印设置信息
     */
    String GetShopPrintTemplateInfo = serverAddr + "GetShopPrintTemplateInfo";

    /***保存打印设置信息
     */
    String SaveShopPrintTemplate = serverAddr + "SaveShopPrintTemplate";

    /***获取交班数据 新接口*/
    String FindGMShiftTurnOverData = serverAddr + "FindGMShiftTurnOverData";

    /***交班 新接口*/
    String SaveMGShiftTurnOverData = serverAddr + "SaveMGShiftTurnOverData";

    /***获取交班记录*/
    String GetMGUserShiftTurnoverStatisticsPage = "/StatisticalReport/GetMGUserShiftTurnoverStatisticsPage";

    /***获取交班详情*/
    String FindGMUserShiftTurnoverStatisticsData = "/StatisticalReport/FindGMUserShiftTurnoverStatisticsData";

    /***更新并获取当前交班单*/
    String UpdateGMShiftTurnoverPrintNum = "/StatisticalReport/UpdateGMShiftTurnoverPrintNum";

    /***商城订单开票、消费单据开票*/
    String SetConsumerOrderIsInvoiced = serverAddr + "SetConsumerOrderIsInvoiced";

    /***充值单据开票*/
    String SetRechargeOrderIsInvoiced = serverAddr + "SetRechargeOrderIsInvoiced";

    /***充次单据开票*/
    String SetCountOrderIsInvoiced = serverAddr + "SetCountOrderIsInvoiced";

    /***会员卡单据开票*/
    String SetMemCardOrderIsInvoiced = serverAddr + "SetMemCardOrderIsInvoiced";

    /**
     * APP 订单状态查询
     **/
    String AppCheckConsumeOrder = serverAddr + "AppCheckConsumeOrder";

    /*** 获取银行卡撤销、退货信息 **/
    String FindBackCardRevokeInfo = serverAddr + "FindBackCardRevokeInfo";

    /*** 验证撤单超级密码是否正确 **/
    String CheckRevokePwd = serverAddr + "CheckRevokePwd";

    /***单据转移 1、 获取当前操作员同门店下其他操作员**/
    String GetMasterInfoForAppOrderTransfer = serverAddr + "GetMasterInfoForAppOrderTransfer";

    /***单据转移*/
    String OrderTransferForApp = serverAddr + "OrderTransferForApp";

    /***根据店铺与油品种类获取油品列表*/
    String GetOilsGoodPageListForApp = serverAddr + "GetOilsGoodPageListForApp";

    /***修改油品信息*/
    String UpdateOilsGoodForApp = serverAddr + "UpdateOilsGoodForApp";

    /***优惠活动获取会员等级*/
    String GetLevelList = serverAddr + "GetLevelList";

    /***优惠活动获取门店列表*/
    String GetShopData = serverAddr + "GetShopData";

    /***优惠活动获取服务项目*/
    String SelectBaseServiceGoodsPageForActivity = serverAddr + "SelectBaseServiceGoodsPageForActivity";

    /***获取优惠活动信息*/
    String GetActivityDetail = serverAddr + "GetActivityDetail";

    /***获取银行卡未支付订单列表*/
    String GetBankOrderLogByPage = serverAddr + "GetBankOrderLogByPage";
    /***获取银行卡未支付订单详情*/
    String GetBankOrderLogDetail = serverAddr + "GetBankOrderLogDetail";
    /***补单*/
    String HandleBankSupplement = serverAddr + "HandleBankSupplement";
    /***银行卡支付失败 未查询到真实支付记录的补单*/
    String HandleBankPayFail = serverAddr + "HandleBankPayFail";
}