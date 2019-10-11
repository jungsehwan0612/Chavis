
import React, { Component } from 'react';
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import ViewWeekIcon from '@material-ui/icons/ViewWeek';
import TodayIcon from '@material-ui/icons/Today';
import InfoIcon from '@material-ui/icons/Info';

class Menu extends Component {
  render() {
    return (
        <div>
        <ListItem button>
          <ListItemIcon>
            <TodayIcon/>
          </ListItemIcon>
          <ListItemText primary="오늘의 예약" />
        </ListItem>
        <ListItem button>
          <ListItemIcon>
            <ViewWeekIcon/>
          </ListItemIcon>
          <ListItemText primary="1주일 예약" />
        </ListItem>
        <ListItem button>
          <ListItemIcon>
            <InfoIcon/>
          </ListItemIcon>
          <ListItemText primary="정비소 정보" />
        </ListItem>
      </div>
    );
  }
}

export default Menu;