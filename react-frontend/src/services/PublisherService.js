import axios from 'axios'

const PUBLISHERS_REST_API_URL = 'http://localhost:9090/api/publishers';

class PublisherService {

    getPublishers(){
        return axios.get(PUBLISHERS_REST_API_URL);
    }
}
export default new PublisherService();