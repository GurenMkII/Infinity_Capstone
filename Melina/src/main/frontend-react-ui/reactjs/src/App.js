import React from 'react';
import './App.css';

import { Container, Row, Col } from 'react-bootstrap';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';

import NavBar from './components/NavBar';
import Welcome from './components/Welcome';
import Movies from './components/Movies';
import TVShows from './components/TVShows';
import Watchlist from './components/Watchlist';
import Footer from './components/Footer';

function App() {
  const marginTop = {
    marginTop: "20px"
  };

  return (
    <Router>
      <NavBar />
      <div>
        <Route path="" exact component={Welcome} />
      </div>
      <Container>
        <Row>
          <Col lg={12} style={marginTop}>
            <Switch>
              <Route path="/addTV" exact component={TVShows} />
              <Route path="/addMovie" exact component={Movies} />
              <Route path="/list" exact component={Watchlist} />
            </Switch>
          </Col>
        </Row>
      </Container>
      <Footer />
    </Router>
  );
}

export default App;