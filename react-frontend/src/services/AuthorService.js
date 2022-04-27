import axios from 'axios'

const AUTHORS_REST_API_URL = 'http://localhost:9090/api/authors';

class AuthorService {

    getAuthors(){
        return axios.get(AUTHORS_REST_API_URL);
    }
}
export default new AuthorService();