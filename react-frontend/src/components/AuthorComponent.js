import React from 'react';
import AuthorService from '../services/AuthorService';
import MenuComponent from './MenuComponent';

class AuthorComponent extends React.Component{

    constructor(props){
        super(props)
        this.state = {
            authors: []
        }
    }

    componentDidMount(){
        AuthorService.getAuthors().then((response) => {
            this.setState({ authors: response.data })
        });
    }

    render(){
        return(
            <>
            <MenuComponent/>
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
            </>
        );
    }
}

export default AuthorComponent;