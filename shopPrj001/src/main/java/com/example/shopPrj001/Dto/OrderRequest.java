package com.example.shopPrj001.Dto;

import java.util.List;

public class OrderRequest {
    private List<OrderItem> orderItems;

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public static class OrderItem {
    	private Long sbno;
        private String pname;
        private Long amount;
        private Long price;
        private Long totalPrice;
        
        
        
        public Long getSbno() {
			return sbno;
		}

		public void setSbno(Long sbno) {
			this.sbno = sbno;
		}

		public Long getPrice() {
			return price;
		}

		public void setPrice(Long price) {
			this.price = price;
		}

		public Long getTotalPrice() {
			return totalPrice;
		}

		public void setTotalPrice(Long totalPrice) {
			this.totalPrice = totalPrice;
		}

		public String getPname() {
            return pname;
        }

        public void setPname(String pname) {
            this.pname = pname;
        }

        public Long getAmount() {
            return amount;
        }

        public void setAmount(Long amount) {
            this.amount = amount;
        }
    }
}
