import Link from '@material-ui/core/Link';
import React, { useState, useEffect } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';

function createData(id, reserveTime, clientName, useRemoteKey, engineerName, repairTime) {
    return { id, reserveTime, clientName, useRemoteKey, engineerName, repairTime };
}



const useStyles = makeStyles(theme => ({
    seeMore: {
        marginTop: theme.spacing(3),
    }
}));

export default function Orders() {

    const [users, setUsers] = useState([]);

    async function getUsers() {
        const response = await fetch('https://jsonplaceholder.typicode.com/users');
        const users = await response.json();
        setUsers(users);
    }
    useEffect(() => {
        getUsers();
    }, []);
    const rows = [
        createData(0, '2019/09/23 17:50', '정세환', ' 사용', '황민승', '2019/09/25 15:30')
    ];
    const classes = useStyles();
    return (
        <React.Fragment>
            <Table>
                <TableHead>
                    <TableRow>
                        <TableCell>예약 시간</TableCell>
                        <TableCell>회원 이름</TableCell>
                        <TableCell>원격키 사용 여부</TableCell>
                        <TableCell>정비사 이름</TableCell>
                        <TableCell>작업 완료 시간</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {rows.map(row => (
                        <TableRow key={row.id}>
                            <TableCell>{row.reserveTime}</TableCell>
                            <TableCell>{row.clientName}</TableCell>
                            <TableCell>{row.useRemoteKey}</TableCell>
                            <TableCell>{row.engineerName}</TableCell>
                            <TableCell align="center">{row.repairTime}</TableCell>
                        </TableRow>
                    ))}
                </TableBody>
            </Table>
            <div className={classes.seeMore}>
                <Link color="primary" href="javascript:;">
                    See more orders
        </Link>
            </div>
            <ul>
                {users.map(user => (
                    <li>{user.name}</li>
                ))}
            </ul>
        </React.Fragment>
    );
}