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
