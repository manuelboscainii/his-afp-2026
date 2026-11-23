export type TApiResponseStatus = "SUCCESS" | "ERROR" | "FAIL";
export interface IApiResponse<T> {
  status: TApiResponseStatus;
  statusCode: number;
  timestamp: string;
  data: T;
}

export interface Page<K> {
  content: K;
  empty: boolean;
  first: boolean;
  last: boolean;
  number: number;
  numberOfElements: number;
  pageable: Pageable;
  size: number;
  sort: Sort;
  totalElements: number;
  totalPages: number;
}

export interface Pageable {
  offset: number;
  pageNumber: number;
  pageSize: number;
  paged: boolean;
  sort: Sort;
  unpaged: boolean;
}

export interface Sort {
  empty: boolean;
  sorted: boolean;
  unsorted: boolean;
}

export interface IPathology {
  code: string;
  description: string;
}


export type TApiResponsePathology = IApiResponse<Page<IPathology[]>>;
