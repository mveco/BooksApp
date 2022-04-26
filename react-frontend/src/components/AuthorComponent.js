import React, {Component} from 'react';
import AuthorService from '../services/AuthorService';

class AuthorComponent extends Component{

    constructor(props){
        super(props)
        this.state = {
            users: []
        }
    }

    componentDidMount(){
        AuthorService.getAuthors().then((response) => {
            this.setState({ users: response.data })
        });
    }

    render(){
        return(
            <div>
                <h3 className='text-center'>Authors List</h3>
                <table className='table table-stripped'>
                    <thead>
                        <tr>
                            <th>AuthorID</th>
                            <th>AuthorName</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.authors.map(
                                author => 
                                <tr key = {author.id}>
                                    <td>{author.id}</td>
                                    <td>{author.name}</td>
                                </tr>
                            )
                        }
                    </tbody>
                </table>
            </div>
        );
    }
}

export default AuthorComponent;