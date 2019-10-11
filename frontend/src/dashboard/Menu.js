
import React, { useState, useEffect } from 'react';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';

export default function Menu() {

  const [info, setInfo] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/Chavis/Bodyshop/info.do')
      .then(response => response.json())
      .then(info => {
        setInfo(info);
      });
  }, []);


  return (
    <div>
      <ListItem>
        <ListItemText primary={info['bodyshop_name']} />
      </ListItem>
      <ListItem button>
        <ListItemText primary={info['bodyshop_address']} />
      </ListItem>
    </div>
  );
}