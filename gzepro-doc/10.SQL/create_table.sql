-- 测试SQL

DROP TABLE IF EXISTS demo_product_category;

DROP TABLE IF EXISTS demo_product_info;

/*==============================================================*/
/* Table: demo_product_category                                 */
/*==============================================================*/
CREATE TABLE demo_product_category
(
   category_id          VARCHAR(64) NOT NULL COMMENT '商品类目id',
   category_name        VARCHAR(64) COMMENT '类目名称',
   category_type        INT NOT NULL COMMENT '类目编号（唯一））',
   create_time          TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   update_time          TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
   PRIMARY KEY (category_id),
   KEY AK_uqe_category_type (category_type)
);

ALTER TABLE demo_product_category COMMENT '商品类目表';

/*==============================================================*/
/* Index: uqe_category_type                                     */
/*==============================================================*/
CREATE UNIQUE INDEX uqe_category_type ON demo_product_category
(
   category_type
);

/*==============================================================*/
/* Table: demo_product_info                                     */
/*==============================================================*/
CREATE TABLE demo_product_info
(
   product_id           VARCHAR(64) NOT NULL COMMENT '商品id',
   category_type        INT COMMENT '商品类目编号',
   product_name         VARCHAR(64) COMMENT '名称',
   product_price        DECIMAL(10,2) DEFAULT 0 COMMENT '单价',
   product_stock        INT DEFAULT 0 COMMENT '库存',
   product_description  VARCHAR(512) COMMENT '描述',
   product_icon         VARCHAR(512) COMMENT '小图',
   product_status       INT DEFAULT 0 COMMENT '状态（0正常，1下架；默认0）',
   create_time          TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   update_time          TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
   PRIMARY KEY (product_id)
);

ALTER TABLE demo_product_info COMMENT '商品信息表';

ALTER TABLE demo_product_info ADD CONSTRAINT FK_Reference_1 FOREIGN KEY (category_type)
      REFERENCES demo_product_category (category_type) ON DELETE RESTRICT ON UPDATE RESTRICT;
