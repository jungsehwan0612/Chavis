import Link from '@material-ui/core/Link';
import React, { useState, useEffect } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';

function createData(reservation_time, client_name, key, repaired_person, repaired_time) {

  var temp = key!=="NO"? key:"사용 안함";
  return { reservation_time, client_name, temp, repaired_person, repaired_time }

}

export default function Orders() {

  const [orders, setOrders] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/Chavis/Reservation/list.do')
      .then(response => response.json())
      .then(orders => {
        setOrders(orders);
      });
  }, []);

  const rows = [];
  orders.forEach(order => {
    rows.push(createData(order['reservation_time'], order['client_name'], order['key'], order["repaired_person"], order['repaired_time']))
  })

  const classes = makeStyles(theme => ({
    seeMore: {
      marginTop: theme.spacing(3),
    }
  }));
  return (
    <React.Fragment>
      <Table>
        <TableHead>
          <TableRow>
            <TableCell>예약 시간</TableCell>
            <TableCell>회원 이름</TableCell>
            <TableCell>원격키</TableCell>
            <TableCell>정비사 이름</TableCell>
            <TableCell>작업 완료 시간</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {rows.map(row => (
            <TableRow>
              <TableCell>{row.reservation_time}</TableCell>
              <TableCell>{row.client_name}</TableCell>
              <TableCell>{row.temp}</TableCell>
              <TableCell>{row.repaired_person}</TableCell>
              <TableCell align="center">{row.repaired_time}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
      <div className={classes.seeMore}>
        <Link color="primary" href="public/order_detail.html">
          이번 주 예약 확인
        </Link>
      </div>
    </React.Fragment>
  );
}