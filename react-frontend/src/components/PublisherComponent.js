import React from 'react';
import PublisherService from '../services/PublisherService';
import MenuComponent from './MenuComponent';

class PublisherComponent extends React.Component{

    constructor(props){
        super(props)
        this.state = {
            publishers: []
        }
    }

    componentDidMount(){
        PublisherService.getPublishers().then((response) => {
            this.setState({ publishers: response.data })
        });
    }

    render(){
        return(
            <>
            <MenuComponent/>
            <div>
                <h3 className='text-center'>Publishers List</h3>
                <table className='table table-stripped'>
                    <thead>
                        <tr>
                            <th>PublisherID</th>
                            <th>PublisherName</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.publishers.map(
                                publisher => 
                                <tr key = {publisher.id}>
                                    <td>{publisher.id}</td>
                                    <td>{publisher.name}</td>
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

export default PublisherComponent;