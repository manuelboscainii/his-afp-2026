export type IStatoSio = "UP" | "DOWN" | "OUT_OF_SERVICE" | 'UNKNOWN' | 'UNAVAILABLE';

export interface IStatoServiziSio {
  components: IActuatorComponent;
  groups: string[];
  status: IStatoSio;
}

export interface IActuatorComponent {
  db: Db;
  diskSpace: DiskSpace;
  livenessState: LivenessState;
  ping: Ping;
  readinessState: ReadinessState;
  ssl: Ssl;
}

export interface Db {
  details: IDBDetails;
  status: IStatoSio;
}

export interface IDBDetails {
  database: string;
  validationQuery: string;
  error?: string;
}

export interface DiskSpace {
  details: IDiskSpaceDetails;
  status: IStatoSio;
}

export interface IDiskSpaceDetails {
  total: number;
  free: number;
  threshold: number;
  path: string;
  exists: boolean;
}

export interface LivenessState {
  status: IStatoSio;
}

export interface Ping {
  status: IStatoSio;
}

export interface ReadinessState {
  status: IStatoSio;
}

export interface Ssl {
  details: ISSLDetails;
  status: IStatoSio;
}

export interface ISSLDetails {
  expiringChains: unknown[];
  invalidChains: unknown[];
  validChains: unknown[];
}

export const STATO_SIO_MOCK: IStatoServiziSio = {
  components: {
    db: {
      details: {
        database: 'N/A',
        validationQuery: 'N/A',
      },
      status: 'UP',
    },
    diskSpace: {
      details: {
        total: -1,
        free: -1,
        threshold: -1,
        path: '',
        exists: false,
      },
      status: 'UNKNOWN',
    },
    livenessState: {
      status: 'UNKNOWN',
    },
    ping: {
      status: 'UNKNOWN',
    },
    readinessState: {
      status: 'UNKNOWN',
    },
    ssl: {
      details: {
        expiringChains: [],
        invalidChains: [],
        validChains: [],
      },
      status: 'UNKNOWN',
    },
  },
  groups: [],
  status: 'UNKNOWN',
};
