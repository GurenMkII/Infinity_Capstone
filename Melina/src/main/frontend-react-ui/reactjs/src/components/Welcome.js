import React from 'react';

import { Jumbotron } from 'react-bootstrap';

class Welcome extends React.Component {
    render() {
        return (
            <Jumbotron fluid>
                <h3>Welcome to Stream</h3>
                <p>
                    We are glad you're here! With STREAM you can easily find information about your favorite movies and TV shows and even save them to your 'Watchlist' to view later.
                </p>
            </Jumbotron>
        )
    }
}

export default Welcome;