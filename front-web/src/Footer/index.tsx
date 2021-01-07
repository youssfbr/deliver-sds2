import './styles.css';
import { ReactComponent as YouTubeIcon } from './youtube.svg';
import { ReactComponent as InstagramIcon } from './instagram.svg';
import { ReactComponent as LinkedinIcon } from './linkedin.svg';

function Footer() {
  return (
    <footer className="main-footer">
      <span>App desenvovido durante a 2a ed. do evento Semana DevSuperior</span>
      <div className="footer-icons">
        <a href="https://www.youtube.com/c/AlissonYoussf" target="_new">
          <YouTubeIcon />
        </a>
        <a href="https://www.linkedin.com/in/youssf/" target="_new">
          <LinkedinIcon />
        </a>
        <a href="https://www.instagram.com/youssf_br/" target="_new">
          <InstagramIcon />
        </a>
      </div>
    </footer>
  )
}

export default Footer;