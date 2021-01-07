import { useEffect } from 'react';

type Props = {
  message: string;
};

function Hello({ message }: Props) {
  console.log('iniciou1');

  useEffect(() => {
    console.log('iniciou');
  }, []);

  return <h1>Component {message}</h1>;
}

export default Hello;
