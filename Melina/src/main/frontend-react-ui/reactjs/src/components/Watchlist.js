import React, { Component } from 'react';
import { Card, Table } from 'react-bootstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faList } from '@fortawesome/free-solid-svg-icons'
import axios from 'axios';

export default class Watchlist extends Component {

    constructor(props){
        super(props);
        this.state = {
            titles : []
        };
    }

    componentDidMount(){
        axios.get("https://api.themoviedb.org/3/movie/popular?api_key=b644ab6b14fc5346cabffe34357d92a0&language=en-US&page=1")
            .then(response => response.data)
            .then((data) => {
                this.setState({titles: data});
            });
    }

    render() {
        return (
            <Card className={"border border-dark bg-dark text-white"}>
                <Card.Header><FontAwesomeIcon icon={faList} /> Watchlist</Card.Header>
                <Card.Body>
                    <Table striped bordered hover variant="dark">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Image</th>
                                <th>Title</th>
                                <th>Director</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr align="center">
                                <td colSpan="6">{this.state.titles.length} Movies Available</td>
                            </tr>
                        </tbody>
                    </Table>
                </Card.Body>
            </Card>

        );
    }
}

// {/* <Card className={"border border-dark bg-dark text-white"}>
// <Card.Img variant="top" src="#" />
// <Card.Body>
//     <Card.Title>Card Title</Card.Title>
//     <Card.Text>
//         Using as a place holder atm to later insert movies. Possibly make into a component
// </Card.Text>
// </Card.Body>

// </Card> */}