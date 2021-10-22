package pms.common.paging;

import org.springframework.data.domain.Sort;

public final class PageRequest {

	private int page;
	private int size;
	private Sort.Direction direction;

	public void setPage(int page) {
		this.page = page;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setDirection(Sort.Direction direction) {
		this.direction = direction;
	}

	public org.springframework.data.domain.PageRequest of(){
		return org.springframework.data.domain.PageRequest.of(page -1, size, direction, "createdAt");

	}
}
