import React, { Component } from 'react';

import { Card } from 'react-bootstrap';

export default class Movies extends Component {
    render() {
        return (
            <Card className={"border border-dark bg-dark text-white"}>
                <Card.Img variant="top" src="#" />
                <Card.Body>
                    <Card.Title>Movies</Card.Title>
                    <Card.Text>
                        Using as a place holder atm to later insert movies. Possibly make into a component
                    </Card.Text>
                </Card.Body>
            </Card>
        );
    }
}
